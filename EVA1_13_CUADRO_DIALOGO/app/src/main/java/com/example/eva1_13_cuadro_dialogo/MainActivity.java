package com.example.eva1_13_cuadro_dialogo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCDSistema(View v){
        new AlertDialog.Builder(this)
                .setTitle("Cuadro de dialogo kawai")
                .setMessage("Hola sempai")
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(getApplicationContext(),"boton ok sempai", Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("no",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"boton no sempai", Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"boton cancel sempai", Toast.LENGTH_SHORT).show();
                    }
                }).show();


    }

    public void onClickCDCustom(View v){
        Dialog dlgMiCuadroDialogo = new Dialog(this);
        dlgMiCuadroDialogo.setContentView(R.layout.cuadro_dialogo);

        TextView txtVwText;
        EditText editText;
        Button btnButton;

        txtVwText = dlgMiCuadroDialogo.findViewById(R.id.txtVwText);
        editText = dlgMiCuadroDialogo.findViewById(R.id.txtVwDatos);
        btnButton = dlgMiCuadroDialogo.findViewById(R.id.btnButton);
        txtVwText.setText("este es un cuadro de dialogo personalizado por mi sempai!");
        btnButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        dlgMiCuadroDialogo.dismiss();
                    }
                }
        );
        dlgMiCuadroDialogo.show();
    }
}