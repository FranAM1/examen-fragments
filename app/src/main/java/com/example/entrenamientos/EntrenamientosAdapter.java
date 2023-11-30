package com.example.entrenamientos;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


// INTENTO DE ADAPTADOR PARA METER IMAGENES EN LA LISTA DE ENTRENAMIENTOS
public class EntrenamientosAdapter extends ArrayAdapter<EntrenamientosData> {
    private Context context;
    private int layoutResourceId;
    private EntrenamientosData[] data;

    public EntrenamientosAdapter(Context context, int layoutResourceId, EntrenamientosData[] data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntrenamientosData entrenamiento = data[position];

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        ImageView imagen = convertView.findViewById(R.id.imagenEntrenamiento);
        TextView titulo = convertView.findViewById(R.id.tituloEntrenamiento);

        imagen.setImageResource(entrenamiento.getImagen());
        titulo.setText(entrenamiento.getNombre());

        return convertView;
    }
}