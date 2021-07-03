package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTel, edtMensa;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTel = findViewById(R.id.edtTel);
        edtMensa = findViewById(R.id.edtMensa);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    public void onClick(View view){
        String sTel, sMensa;

        sTel = "smsto:" + edtTel.getText().toString();
        sMensa = edtMensa.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        intent.putExtra("sms_body", sMensa);

    }

}