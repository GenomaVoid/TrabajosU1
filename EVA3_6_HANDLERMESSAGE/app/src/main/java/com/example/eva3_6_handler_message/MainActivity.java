package com.example.eva3_6_handler_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensa;
    Thread thread;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //aqui podemos podificar la interfaz grafica
            //trabajo ligero --> una tarea intensa va a trabar la interfas
            String cade = (String)msg.obj;
            int what = msg.what;
            txtVwMensa.append("El hilo = " + what + "imprime: " + cade + "\n");
        }
    };

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
                        String cade = "i = "+ i;
                        i++;
                        //solicitamos un mensaje
                        //podemos poner datos
                        Message message = handler.obtainMessage(1000, cade);
                        //regresarlo
                        handler.sendMessage(message);
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