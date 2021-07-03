package com.example.eva2_7_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }

    public void onClick(View v){
        miClass miClass = new miClass();
        miClass.setParam1(100);
        miClass.setParam2(200);

        Bundle bundle = new Bundle();
        bundle.putString("Mensaje","hola mundo cruel");
        bundle.putInt("Edad",100);
        bundle.putBoolean("Empleado", true);
        bundle.putSerializable("puerba", miClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    class miClass implements Serializable {
        private int param1;
        private int param2;

        public int getParam1() {
            return param1;
        }

        public void setParam1(int param1) {
            this.param1 = param1;
        }

        public int getParam2() {
            return param2;
        }

        public void setParam2(int param2) {
            this.param2 = param2;
        }
    }
}