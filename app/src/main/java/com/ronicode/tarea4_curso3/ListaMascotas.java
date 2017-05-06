package com.ronicode.tarea4_curso3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ronicode.tarea4_curso3.adaptadores.PageAdaptador;
import com.ronicode.tarea4_curso3.fragments.PerfilFragment;
import com.ronicode.tarea4_curso3.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionbar);

        getSupportActionBar().setIcon(R.drawable.dog_footprint_filled);

        toolbar = (Toolbar) findViewById(R.id.tollbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewpage();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private void setUpViewpage() {

        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), adicionarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil_48);
    }

    private ArrayList<Fragment> adicionarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icono_favorito, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.itmenuContacto:
                Intent intentContacto = new Intent(this, Contacto.class);
                startActivityForResult(intentContacto, 1);
                return true;

            case R.id.itmenuAcercade:
                Intent intentAcercaDe = new Intent(this, AcercaDe.class);
                startActivityForResult(intentAcercaDe, 2);
                return true;

            case R.id.itmenuFavorito:
                Intent intent = new Intent(this, MascotasFavoritas.class);
                startActivityForResult(intent, 0);
                return true;

            default:
                return false;

        }

    }
}
