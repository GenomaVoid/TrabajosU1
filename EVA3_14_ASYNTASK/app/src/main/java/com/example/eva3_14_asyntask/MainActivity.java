package com.example.eva3_14_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMostrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(10);
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,Void>{
        @Override
        protected void onPreExecute() {//interactuar con ui
            super.onPreExecute();
            txtVwMostrar.append("iniciando la tarea");
        }

        @Override
        protected Void doInBackground(Integer... integers) {//runn
            int limite = integers[0], time = integers[1];
            for(int i = 0; i < limite; i++){
                try {
                    Thread.sleep(time);
                    publishProgress("i =" +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;


        }

        @Override
        protected void onProgressUpdate(String... values) {//interactuar con ui
            super.onProgressUpdate(values);
            txtVwMostrar.append(values[0]  + "\n");
        }

        @Override
        protected void onPostExecute(Void s) {//interactuar con ui
            super.onPostExecute(s);
            txtVwMostrar.append("fin la tarea");
        }




    }

}