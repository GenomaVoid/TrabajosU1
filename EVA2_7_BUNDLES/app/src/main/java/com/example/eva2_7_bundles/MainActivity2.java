package com.example.eva2_7_bundles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        MainActivity.miClass miclass = (MainActivity.miClass)bundle.getSerializable("Prueba");
        Toast.makeText(this,bundle.getString("mensaje")+" "+ bundle.getInt("Edad")+" "+ bundle.getBoolean("Empleado")+" "+miclass.getParam1()+" "+ miclass.getParam2(), Toast.LENGTH_LONG).show();

    }


}