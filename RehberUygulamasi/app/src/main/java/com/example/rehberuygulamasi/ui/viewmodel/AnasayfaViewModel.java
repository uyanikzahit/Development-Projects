package com.example.rehberuygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rehberuygulamasi.data.entity.Kisiler;
import com.example.rehberuygulamasi.data.repo.*;

import java.util.ArrayList;
import java.util.List;

public class AnasayfaViewModel extends ViewModel {
    private KisilerDaoRepository krepo = new KisilerDaoRepository();
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData();

    public AnasayfaViewModel(){
        kisileriYukle();
        kisilerListesi = krepo.kisileriGetir();
    }
    public void ara(String aramaKelimesi){
        krepo.kisiAra(aramaKelimesi);
    }

    public void sil (int kisi_id){
        krepo.kisiSil(kisi_id);

    }

    public void kisileriYukle(){

        krepo.tumKisileriAl();
    }

}
