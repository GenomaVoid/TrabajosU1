package com.example.eva1_12_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Clima[] aClimaCd = {
            new Clima(R.drawable.atmospher, "Kalos", 28, "para pokemon agua"),
            new Clima(R.drawable.cloudy, "sinnon", 28, "para pokemon agua"),
            new Clima(R.drawable.rainy, "hoen", 28, "para pokemon agua"),
            new Clima(R.drawable.light_rain, "2", 28, "para pokemon agua"),
            new Clima(R.drawable.snow, "3", 28, "para pokemon agua"),
            new Clima(R.drawable.sunny, "4", 28, "para pokemon agua"),
            new Clima(R.drawable.tornado, "5", 28, "para pokemon agua"),
            new Clima(R.drawable.thunderstorm, "6", 28, "para pokemon agua"),


    };

    ListView listakawai;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart(){
        super.onStart();
        listakawai = findViewById(R.id.listakawai);
        listakawai.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
    }
}