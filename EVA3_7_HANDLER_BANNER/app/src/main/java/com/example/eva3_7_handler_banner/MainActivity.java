package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    Thread tBanner;
    int iCont = 0;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int image;
            if(iCont == 0){
                image = R.drawable.eko_i4ixcaeovbv;
                iCont++;
            } else if (iCont == 1){
                image = R.drawable.ekr5inzucaewqbs;
                iCont++;
            } else {
                image = R.drawable.ekrfyhawkaadne4;
                iCont=0;
            }
            imgVwBanner.setImageResource(image);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);

        tBanner = new Thread(){
            @Override
            public void run(){
                super.run();
                int i = 0;
                while(true){
                    try{
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage();
                        handler.sendMessage(message);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}