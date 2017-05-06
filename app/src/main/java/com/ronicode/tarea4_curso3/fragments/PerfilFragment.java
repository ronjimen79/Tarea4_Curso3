package com.ronicode.tarea4_curso3.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.ronicode.tarea4_curso3.R;
import com.ronicode.tarea4_curso3.adaptadores.MascotasPerfilAdaptador;
import com.ronicode.tarea4_curso3.pojo.Mascotas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager llm;
    private RecyclerView.Adapter adaptador;
    private GridLayoutManager glm;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        CircularImageView circularImageView = (CircularImageView)v.findViewById(R.id.civPerfil);

        circularImageView.setBorderColor(getResources().getColor(R.color.Teal));
        circularImageView.setBorderWidth(10);

        circularImageView.addShadow();

        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.GREEN);

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 10));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 6));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 9));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 4));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 7));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 11));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 5));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 2));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 3));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 8));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 1));
        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 12));

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);
        listaMascotas.setHasFixedSize(true);
        glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);

        adaptador = new MascotasPerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

        // Inflate the layout for this fragment
        return v;
    }

}
