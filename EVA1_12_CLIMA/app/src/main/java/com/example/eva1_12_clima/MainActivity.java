package com.example.eva1_12_clima;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*Clima[] aClimaCd = {
            new Clima(R.drawable.atmospher, "Kalos", 28, "para pokemon agua"),
            new Clima(R.drawable.cloudy, "sinnon", 28, "para pokemon agua"),
            new Clima(R.drawable.rainy, "hoen", 28, "para pokemon agua"),
            new Clima(R.drawable.light_rain, "2", 28, "para pokemon agua"),
            new Clima(R.drawable.snow, "3", 28, "para pokemon agua"),
            new Clima(R.drawable.sunny, "4", 28, "para pokemon agua"),
            new Clima(R.drawable.tornado, "5", 28, "para pokemon agua"),
            new Clima(R.drawable.thunderstorm, "6", 28, "para pokemon agua"),


    };*/

    List<Clima> lstCiudades = new ArrayList<>();

    ListView listakawai;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    protected void onStart(){
        super.onStart();
        listakawai = findViewById(R.id.listakawai);
        //listakawai.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
        ConexionClima cc = new ConexionClima();
        cc.execute("http://api.openweathermap.org/data/2.5/find?lat=28.6&lon=-106&cnt=30&units=metric&appid=1d93b78bb8395b6e583a5b8881c7e585");
    }

    class ConexionClima extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResu = null;

            try {
                URL url = new URL(sUrl);

                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

                if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine();  //asdas
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            Log.wtf("conexion",s);
            if(!(s.equals("") || s == null)){
                try {
                    JSONObject jsonobject = new JSONObject(s);
                    JSONArray jsaCiudades = jsonobject.getJSONArray("list");
                    for (int i = 0; i < jsaCiudades.length(); i++){
                        JSONObject jsonCiudad = jsaCiudades.getJSONObject(i);
                        Clima climaCiudad = new Clima();
                        climaCiudad.setCiudad(jsonCiudad.getString("name"));
                        JSONObject jsonMain = jsonCiudad.getJSONObject("main");
                        climaCiudad.setTemp(jsonCiudad.getDouble("temp"));
                        JSONArray jsaWheather = jsonCiudad.getJSONArray("weather");

                        JSONObject jsonClimaActual = jsaWheather.getJSONObject(0);
                        climaCiudad.setDesc(jsonClimaActual.getString("description"));
                        int id = jsonClimaActual.getInt("id");
                        if(id < 300){
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        }else if(id < 400){
                            climaCiudad.setImagen(R.drawable.light_rain);
                        }else if(id < 600){
                            climaCiudad.setImagen(R.drawable.rainy);
                        }else if(id < 700){
                            climaCiudad.setImagen(R.drawable.snow);
                        }else if(id < 801){
                            climaCiudad.setImagen(R.drawable.sunny);
                        }else if(id < 900){
                            climaCiudad.setImagen(R.drawable.cloudy);
                        }else{
                            climaCiudad.setImagen(R.drawable.tornado);
                        }
                        lstCiudades.add(climaCiudad);
                    }
                    listakawai.setAdapter(new ClimaAdaptador(MainActivity.this,
                            R.layout.mi_lista_clima,
                            lstCiudades));

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }

    }
}