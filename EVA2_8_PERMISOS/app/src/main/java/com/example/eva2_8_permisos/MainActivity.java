package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtView;
    Intent intent;
    Button btnLlamar;
    final static int PERMISO_LLAMAR = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = findViewById(R.id.btnLlamar);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //pido permisos
            Toast.makeText(this, "no tiene permisos", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},
            PERMISO_LLAMAR);
        }else{
            //ejecuto accion
            Toast.makeText(this, "tiene permisos", Toast.LENGTH_LONG).show();
        }
    }

    protected  void onStart(){
        super.onStart();
        edtView = findViewById(R.id.txtView);
    }

    public void onClick(View v){
        String sTel = "tel:"  +edtView.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        switch(requestCode){
            case PERMISO_LLAMAR:
                if(grantResult[0] == PackageManager.PERMISSION_GRANTED){
                    btnLlamar.setEnabled(true);
                    Toast.makeText(this, "permiso concedido", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "permiso denegado", Toast.LENGTH_LONG).show();
                }break;
        }
    }
}