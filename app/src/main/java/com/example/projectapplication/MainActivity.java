    package com.example.projectapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Place> placeAdapter;
    private ArrayList<Place> placeList = new ArrayList<>();
    private int[] drawableListID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableListID = new int[]{R.drawable.g,R.drawable.sa,R.drawable.pp,R.drawable.p,R.drawable.st};
        placeAdapter = new ArrayAdapter<>(this, R.layout.list_places, placeList);

        ListView list = (ListView) findViewById(R.id.mylistview);
        TextView title = (TextView) findViewById(R.id.titleText);
        TextView text = (TextView) findViewById(R.id.breadText);
        TextView citation = (TextView) findViewById(R.id.citationText);
        ImageView img = (ImageView) findViewById(R.id.imgView);

        list.setAdapter(placeAdapter);

        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a20kimar");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("Place_Click", "Updating information on screen for position " + position);
                updateInfo(img, position, title, text, citation);
            }
        });

        Button knapp = findViewById(R.id.btnAbout);
        knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                Log.d("Button_Click", "Start SecondActivity.");
            }
        });
    }

    private void updateInfo(ImageView i, int p, TextView title, TextView text, TextView citation) {
        i.setImageResource(placeList.get(p).getDrawableID());
        title.setText(placeList.get(p).getName());
        text.setText(placeList.get(p).getAux().getText());
        citation.setText(placeList.get(p).getAux().getCitation());
    }

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Log.d("JSON: ", json);
            try {
                Gson gson = new Gson();
                Place[] places;
                places = gson.fromJson(json, Place[].class);
                placeAdapter.clear();
                for (int i = 0; i < places.length; i++) {
                    placeList.add(new Place(places[i].toString(), places[i].getLocation(), places[i].getCategory(), drawableListID[i], places[i].getAux()));
                }
                placeAdapter.notifyDataSetChanged();

            } catch (JsonSyntaxException e) {
                Log.e("JSON Exception: ", e.getMessage());
            }

        }
    }
}