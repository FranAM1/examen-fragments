package com.example.entrenamientos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class InfoEntrenamiento extends Fragment {
    private int posicion = 0;
    EntrenamientosData[] dataEntrenamientos = new EntrenamientosData[]{
            new EntrenamientosData("Entrenamiento 1", "Descripcion 1", R.drawable.ic_launcher_foreground),
            new EntrenamientosData("Entrenamiento 2", "Descripcion 2", R.drawable.ic_launcher_foreground),
            new EntrenamientosData("Entrenamiento 3", "Descripcion 3", R.drawable.ic_launcher_foreground),
            new EntrenamientosData("Entrenamiento 4", "Descripcion 4", R.drawable.ic_launcher_foreground),
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_info_entrenamiento, container, false);
        TextView titulo = root.findViewById(R.id.tituloEntrenamiento);
        TextView descripcion = root.findViewById(R.id.descripcionEntrenamiento);
        ImageView imagen = root.findViewById(R.id.imagenEntrenamiento);
        if (savedInstanceState != null) {
            posicion = savedInstanceState.getInt("posicion", 0);
        } else {
            try {
                posicion = getArguments().getInt("posicion");
            } catch (Exception e) {
                Log.d("InfoEntrenamiento", "No hay argumentos");
            }
        }

        titulo.setText(dataEntrenamientos[posicion].getNombre());
        descripcion.setText(dataEntrenamientos[posicion].getDescripcion());
        imagen.setImageResource(dataEntrenamientos[posicion].getImagen());

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("posicion", posicion);
        super.onSaveInstanceState(outState);
    }
}

