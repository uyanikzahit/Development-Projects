package com.example.rehberuygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rehberuygulamasi.databinding.*;


import com.example.rehberuygulamasi.R;



public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);
        tasarim.toolbarAnasayfa.setTitle("Kişiler");
        tasarim.fab.setOnClickListener(view ->{

            Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);

        });

        return tasarim.getRoot();



    }
}