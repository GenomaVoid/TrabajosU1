package com.example.acredita_noacredita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwReq, txtVwCalif, txtVwAcredita;
    SeekBar skBrReq, skBrCalif;
    int progresoReq,progresoCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwAcredita=findViewById(R.id.txtVwAcredita);
        txtVwCalif=findViewById(R.id.txtVwCalif);
        txtVwReq=findViewById(R.id.txtVwReq);
        skBrCalif=findViewById(R.id.skBrCalif);
        skBrReq=findViewById(R.id.skBrReq);

        skBrReq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtVwReq.setText("Puntos para acreditar: " + progress);
                progresoReq=progress;
                if(progresoReq>progresoCal){
                    txtVwAcredita.setText("NO ACREDITA!!");
                }else if(progresoReq<=progresoCal){
                    txtVwAcredita.setText("ACREDITA!!");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBrCalif.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtVwCalif.setText("Calificacion: "+progress);
                progresoCal=progress;
                if(progresoReq<=progresoCal) {
                    txtVwAcredita.setText("ACREDITA!!");
                }else if(progresoReq>progresoCal){
                    txtVwAcredita.setText("NO ACREDITA!!");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }




}
