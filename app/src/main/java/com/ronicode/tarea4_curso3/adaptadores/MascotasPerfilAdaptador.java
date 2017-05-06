package com.ronicode.tarea4_curso3.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ronicode.tarea4_curso3.R;
import com.ronicode.tarea4_curso3.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Roni on 5/05/2017.
 */

public class MascotasPerfilAdaptador extends RecyclerView.Adapter<MascotasPerfilAdaptador.MascotaPerfilViewHolder> {

    private ArrayList<Mascotas> mascotaLista;
    Activity activity;

    public MascotasPerfilAdaptador(ArrayList<Mascotas> mascotaLista, Activity activity){
        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }

    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotaperfil, parent, false);
        MascotaPerfilViewHolder mascota = new MascotaPerfilViewHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(MascotaPerfilViewHolder holder, int position) {
        final Mascotas mascota = mascotaLista.get(position);
        holder.tvFavoritoPerfil.setText(String.valueOf(mascota.getFavorito()));
        holder.imgFoto.setImageResource(mascota.getFoto());
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public class MascotaPerfilViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFoto;
        TextView tvFavoritoPerfil;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);

            tvFavoritoPerfil = (TextView) itemView.findViewById(R.id.tvFavoritoPerfil);
            imgFoto = (ImageView) itemView.findViewById(R.id.ivPerfil);

        }
    }
}
