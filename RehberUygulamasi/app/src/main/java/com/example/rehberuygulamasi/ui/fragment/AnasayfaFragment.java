package com.example.rehberuygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.rehberuygulamasi.databinding.*;


import com.example.rehberuygulamasi.R;



public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentAnasayfaBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);
        tasarim.toolbarAnasayfa.setTitle("Kişiler");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);
        tasarim.fab.setOnClickListener(view ->{

            Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);

        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(AnasayfaFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return tasarim.getRoot();



    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ara(newText);
        return true;
    }

    public void ara(String aramaKelimesi){
        Log.e("Kişi Ara", aramaKelimesi);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Kişi anasayfa", " dönüldü");

    }
}