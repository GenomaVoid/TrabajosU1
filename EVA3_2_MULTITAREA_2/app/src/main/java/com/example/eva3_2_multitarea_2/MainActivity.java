package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread miHilo = new Thread(){
          public void run(){
              super.run();


              for(int i=0; i < 10; i++){
                  try{
                      Thread.sleep(1000);
                      Log.wtf("Hilo principal", "i =" + (i+1));
                  } catch(InterruptedException e) {
                      e.printStackTrace();
                  }
              }


          }
        };

        miHilo.start();
        MiHilote miHilote = new MiHilote();
        miHilote.start();


    }

    class MiHilote extends Thread{
        public void run(){
            super.run();


            for(int i=0; i < 10; i++){
                try{
                    Thread.sleep(1000);
                    Log.wtf("Hilo principal", "i =" + (i+1));
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}