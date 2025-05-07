package com.example.rehberuygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.rehberuygulamasi.databinding.*;
import com.example.rehberuygulamasi.data.entity.*;
import com.example.rehberuygulamasi.ui.adapter.*;


import com.example.rehberuygulamasi.R;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentAnasayfaBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);
        tasarim.setAnasayfaFragment(this);
        tasarim.setAnasayfaToolbarBaslik("Kişiler");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);


        ArrayList<Kisiler> kisilerListesi = new ArrayList<>();
        Kisiler k1 = new Kisiler(1,"Zahit","1111");
        Kisiler k2 = new Kisiler(2,"Mehmet","2222");
        Kisiler k3 = new Kisiler(3,"Beyda","3333");
        kisilerListesi.add(k1);
        kisilerListesi.add(k2);
        kisilerListesi.add(k3);

        KisilerAdapter adapter = new KisilerAdapter(requireContext(),kisilerListesi);
        tasarim.setKisilerAdapter(adapter);



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

    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);


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