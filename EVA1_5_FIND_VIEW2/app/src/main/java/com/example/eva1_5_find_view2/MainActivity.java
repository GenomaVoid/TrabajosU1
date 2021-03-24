package com.example.eva1_5_find_view2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView imgVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVwMostrar = findViewById(R.id.imgVwMostrar);

        imgVwMostrar.setImageResource(R.drawable.waifu);

    }
}