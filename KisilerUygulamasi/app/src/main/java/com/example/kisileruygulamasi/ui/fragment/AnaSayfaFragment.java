package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;


public class AnaSayfaFragment extends Fragment {

    private FragmentAnaSayfaBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim =   FragmentAnaSayfaBinding.inflate(inflater, container, false);

        tasarim.toolbarAnasayfa.setTitle("Kişiler");
        tasarim.fab.setOnClickListener(view->{
            Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);
        });
        return tasarim.getRoot();
    }
}