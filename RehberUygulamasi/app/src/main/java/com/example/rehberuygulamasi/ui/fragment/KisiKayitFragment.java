package com.example.rehberuygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rehberuygulamasi.databinding.*;
import com.example.rehberuygulamasi.ui.viewmodel.*;

import com.example.rehberuygulamasi.R;


public class KisiKayitFragment extends Fragment {
    private KisiKayitViewModel viewModel;
    private FragmentKisiKayitBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_kayit,container, false);
        tasarim.setKisiKayitFragment(this);
        tasarim.setKisiKayitToolbarBaslik("Kişi Kayıt");



        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitViewModel.class);
    }

    public void buttonKaydet(String kisi_ad, String kisi_tel){
        viewModel.kayit(kisi_ad,kisi_tel);
    }
}