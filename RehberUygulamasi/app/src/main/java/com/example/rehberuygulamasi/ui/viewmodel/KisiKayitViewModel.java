package com.example.rehberuygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.rehberuygulamasi.data.repo.*;


public class KisiKayitViewModel extends ViewModel{

    private KisilerDaoRepository krepo = new KisilerDaoRepository();
    public void kayit(String kisi_ad, String kisi_tel){
        krepo.kisiKayit(kisi_ad,kisi_tel);
    }
}
