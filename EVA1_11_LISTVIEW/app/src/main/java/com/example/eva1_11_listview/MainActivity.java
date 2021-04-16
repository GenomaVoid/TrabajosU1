package com.example.eva1_11_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listVwDatos;
    String[] aDatos = {
            "Emilia",
            "Rem",
            "Ram",
            "Haruhi",
            "Asahina",
            "Nagato",
            "Misa",
            "Rikka",
            "Nibutani",
            "Dekomori",
            "Nagisa",
            "Senjougahara",
            "Hanekawa",
            "Hanabi",
            "Kirigiri",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        listVwDatos = findViewById(R.id.listVwDatos);
        listVwDatos.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                aDatos
        ));
        listVwDatos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Toast.makeText(this, aDatos[i],Toast.LENGTH_SHORT).show();
    }
}