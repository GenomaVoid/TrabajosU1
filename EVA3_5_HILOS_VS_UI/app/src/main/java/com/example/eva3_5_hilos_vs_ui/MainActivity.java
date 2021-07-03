package com.example.eva3_5_hilos_vs_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.mensa);
        //txtVwMensa.setText("hola mundo sempai");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                  while (true){
                      try{
                          Thread.sleep(1000);
                          String cade = "i = "+ 1;
                          i++;
                          txtVwMensa.append(cade + "\n");
                          Log.wtf("runnable", cade);
                      }catch(InterruptedException e){
                          e.printStackTrace();
                          break;
                      }
                  }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}