package com.example.eva1_12_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClimaAdaptador extends ArrayAdapter<Clima> {
    private Context context;
    private int layout;
    private Clima[] cCiudades;

    public ClimaAdaptador(@NonNull Context context, int resource, @NonNull Clima[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.cCiudades = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //fila no existia
        if(convertView == null){
            convertView = ((Activity)context).getLayoutInflater().inflate(layout,parent,false); //crea el layout
        }/*else{//si no existe

        }*/
        ImageView imgVwClima;
        TextView TxtVwCd,TxtVwTemp,TxtVwDesc;
        //finviewbyid no funciona porque no tenemos activiti main!
        imgVwClima = convertView.findViewById(R.id.imgVwClima);
        TxtVwCd = convertView.findViewById(R.id.txtVwCiudad);
        TxtVwTemp = convertView.findViewById(R.id.txtVwTemp);
        TxtVwDesc = convertView.findViewById(R.id.txtVwDesc);

        imgVwClima.setImageResource(cCiudades[position].getImagen());
        TxtVwCd.setText(cCiudades[position].getCiudad());
        TxtVwTemp.setText(cCiudades[position].getTemp()+"°C");
        TxtVwDesc.setText(cCiudades[position].getDesc());

        return convertView;

    }
}
