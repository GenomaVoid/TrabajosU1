package com.example.eva3_8_load_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVw;
    Bitmap bitmap;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            imgVw.setImageBitmap(bitmap);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        //

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                bitmap = descargarImagen("https://pbs.twimg.com/media/E11UofoUYAg-2yJ?format=jpg&name=large");
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };
        thread.start();

    }

    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}