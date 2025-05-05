package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;


public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false);
        tasarim.setKisiKayitFragment(this);

        tasarim.setKisiKayitToolbarBaslik("Kişi Kayıt");



        return tasarim.getRoot();
    }

    public void buttonKaydet(String kisi_ad, String kisi_tel){
        Log.e("Kişi Kayıt",kisi_ad+" - "+kisi_tel);
    }
}