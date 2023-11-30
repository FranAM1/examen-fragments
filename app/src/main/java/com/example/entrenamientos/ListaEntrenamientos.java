package com.example.entrenamientos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;

public class ListaEntrenamientos extends Fragment {
    String[] lista = {"Entrenamiento 1", "Entrenamiento 2", "Entrenamiento 3", "Entrenamiento 4"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista_entrenamientos, container, false);

        ListView listaEntrenamientos = (ListView) root.findViewById(R.id.listaEntrenamientos);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, lista);
        listaEntrenamientos.setAdapter(adapter);

        listaEntrenamientos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cambiarFragment(position);
            }
        });



        return root;
    }

    private void cambiarFragment(int position) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InfoEntrenamiento fragmentoInfo = new InfoEntrenamiento();

        Bundle bundle = new Bundle();
        bundle.putInt("posicion", position);
        fragmentoInfo.setArguments(bundle);


        if (getResources().getConfiguration().orientation == 2) {
            fragmentTransaction.replace(R.id.infoFragment, fragmentoInfo);
        } else {
            fragmentTransaction.replace(R.id.mainFragment, fragmentoInfo);
        }

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}

