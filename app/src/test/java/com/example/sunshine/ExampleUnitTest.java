package com.example.sunshine;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}

/*package com.example.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    DayNightSwitch dswitch;
    View bg;

    TextView textCity, texttime, textHUmidity, textVision, textFeelsLike, textTemp;
    SearchView searchView;
    ListView listView;
    String[] data;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    String city = "London,uk";
    String key = "4059e087b45050464aef581d4d7acd5f";
    String Curl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + key;


    public class DownloadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            HttpsURLConnection httpsURLConnection;
            InputStream inputStream;
            InputStreamReader inputStreamReader;
            String result = "";


            try {

                url = new URL(strings[0]);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                inputStream = httpsURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data != -1) {
                    result += (char) data;
                    data = inputStreamReader.read();
                }


            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///ID ASSIGNMENT
        textCity = findViewById(R.id.citytext);
        texttime = findViewById(R.id.timetext);
        textHUmidity = findViewById(R.id.humidtext);
        textVision = findViewById(R.id.visiontext);
        textFeelsLike = findViewById(R.id.feeltext);
        textTemp = findViewById(R.id.temptext);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listv);


        ///ARRAY LIST SHIT
        data  = new String[]{"w","e",",2w","we","we"};
        arrayList =  new ArrayList<String>(Arrays.asList(data));
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        //////////////
        //NEW SHIT
        ////////////

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String cityString =(listView.getItemAtPosition(position).toString());
                searchView.setQuery(cityString,true);
            }
        });
        listView.setVisibility(View.GONE);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (arrayList.contains(query)) {
                    arrayAdapter.getFilter().filter(query);
                } else {
                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listView.setVisibility(View.VISIBLE);
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        /////////////////////////


        DownloadJSON downloadJSON = new DownloadJSON();
        Curl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + key;
        try {

            String result = downloadJSON.execute(Curl).get();
            Log.i("JSON", result);

            JSONObject jsonObject = new JSONObject(result);
            String temp = jsonObject.getJSONObject("main").getString("temp");
            String humidity = jsonObject.getJSONObject("main").getString("humidity");
            String feel_like = jsonObject.getJSONObject("main").getString("feels_like");
            String visibility = jsonObject.getString("visibility");
            Long time = jsonObject.getLong("dt");
            String stime = new SimpleDateFormat("dd-M-yyyy  hh:mm aa", Locale.ENGLISH).format(new Date(time * 1000));
            float temper = Float.parseFloat(temp);
            int tmper2 = (int) temper;


            textCity.setText(city);
            textHUmidity.setText(humidity + "g/m3");
            textVision.setText(visibility);
            textFeelsLike.setText(feel_like + "°");
            textTemp.setText(tmper2 + "°C");
            texttime.setText(stime);


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            textCity.setText(e.toString());
        }


////////////DARK MODE STUFF
        dswitch = (DayNightSwitch) findViewById(R.id.dayNight);
        bg = findViewById(R.id.backgroundView);
        dswitch.setDuration(450);
        dswitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    Toast.makeText(MainActivity.this, "Night Mode On", Toast.LENGTH_LONG).show();
                    bg.setAlpha(1f);
                } else {

                    Toast.makeText(MainActivity.this, "Day Mode On", Toast.LENGTH_LONG).show();
                    bg.setAlpha(0f);
                }
            }
        });

    }
}*/