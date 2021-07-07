package com.example.ernesto.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método el botón Siguiente
    public void Siguiete(View view){
        Intent siguiente = new Intent(this, SegundoActivity.class);
        startActivity(siguiente);
    }
}
