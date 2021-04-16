package com.example.eva1_15_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    RecyclerView rcvWLista;

    String[] aDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llenar(aDatos);
        aDatos = new String[100];
        for(int i =0; i<100; i++){
            aDatos[i] = "Elemento no."+i;
        }
        rcvWLista = findViewById(R.id.rcVwLista);
        rcvWLista.setAdapter(new MiAdaptador(aDatos));
        //rcvWLista.setLayoutManager(new LinearLayoutManager(this));
        rcvWLista.setLayoutManager(new GridLayoutManager(this,2));
    }

    public void llenar(String[] args){
        args = new String[100];
        for(int i =0; i<100; i++){
            args[i] = "Elemento no."+i;
        }
    }


}