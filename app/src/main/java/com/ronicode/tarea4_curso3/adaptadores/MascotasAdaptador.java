package com.ronicode.tarea4_curso3.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ronicode.tarea4_curso3.R;
import com.ronicode.tarea4_curso3.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 5/05/2017.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.mascotaViewHolder> {

    private ArrayList<Mascotas> mascotaLista;
    Activity activity;

    public MascotasAdaptador(ArrayList<Mascotas> mascotaLista, Activity activity){

        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }

    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        mascotaViewHolder mascota = new mascotaViewHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(mascotaViewHolder holder, int position) {
        final Mascotas mascota = mascotaLista.get(position);
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvFavoritoCV.setText(String.valueOf(mascota.getFavorito()));
        holder.imgFoto.setImageResource(mascota.getFoto());

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnFavorito.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "te gusta: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public class mascotaViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombreCV;
        ImageView imgFoto;
        ImageButton btnFavorito;
        TextView tvFavoritoCV;

        public mascotaViewHolder(View itemView) {

            super(itemView);

            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvFavoritoCV = (TextView) itemView.findViewById(R.id.tvFavoritoCV);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnFavorito = (ImageButton) itemView.findViewById(R.id.btnFavorito);
        }
    }
}
