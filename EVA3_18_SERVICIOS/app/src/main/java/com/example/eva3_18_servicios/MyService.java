package com.example.eva3_18_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    Thread thread;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("SERVICIO","ONCREATE");
        
    }

    @Override
    public void onStart(Intent intent, int flags) {
        Log.wtf("SERVICIO","ONSTART");
        thread = new Thread() {
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    Log.wtf("servicio", "trabajo en segundo platno");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("SERVICIO","DESTROY");
        thread.interrupt();
    }
}