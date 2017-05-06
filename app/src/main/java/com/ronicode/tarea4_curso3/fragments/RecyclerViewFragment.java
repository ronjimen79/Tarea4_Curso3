package com.ronicode.tarea4_curso3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ronicode.tarea4_curso3.R;
import com.ronicode.tarea4_curso3.adaptadores.MascotasAdaptador;
import com.ronicode.tarea4_curso3.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 5/05/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager llm;
    private RecyclerView.Adapter adaptador;

    public RecyclerViewFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 12));
        mascotas.add(new Mascotas(R.drawable.perro_3_dalton, "Dalton", 10));
        mascotas.add(new Mascotas(R.drawable.perro_1_winnie, "Winnie", 8));
        mascotas.add(new Mascotas(R.drawable.perro_4_minnie, "Minnie", 6));
        mascotas.add(new Mascotas(R.drawable.perro_5_truman, "Truman", 4));
        mascotas.add(new Mascotas(R.drawable.perro_2_leto, "Leto", 1));

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvmascotas);
        llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);

        adaptador = new MascotasAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

        return v;
    }
}
