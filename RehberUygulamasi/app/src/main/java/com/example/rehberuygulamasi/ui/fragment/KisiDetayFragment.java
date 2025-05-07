package com.example.rehberuygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rehberuygulamasi.databinding.*;
import com.example.rehberuygulamasi.ui.fragment.*;
import com.example.rehberuygulamasi.data.entity.*;


import com.example.rehberuygulamasi.R;


public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false);
        tasarim.setKisiDetayFragment(this);

        tasarim.setKisiDetayToolbarBaslik("Kişi Detay");

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();


        tasarim.setKisiNesnesi(gelenKisi);


        return tasarim.getRoot();
    }

    public void buttonGuncelle(int kisi_id, String kisi_ad, String kisi_tel){
        Log.e("Kişi Güncelle",kisi_id +" - "+ kisi_ad+" - "+kisi_tel);
    }
}