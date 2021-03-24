package com.example.eva1_7_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdGroupWaifus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGroupWaifus = findViewById(R.id.rdGroupWaifus);

        rdGroupWaifus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rdBtnSel;
                rdBtnSel = findViewById(i);
                Toast.makeText(getApplicationContext(), rdBtnSel.getText(), Toast.LENGTH_SHORT).show();


                }


        });

    }
}