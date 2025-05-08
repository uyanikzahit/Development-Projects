package com.example.rehberuygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import com.example.rehberuygulamasi.data.repo.*;

public class KisiDetayViewModel extends ViewModel {
    private KisilerDaoRepository krepo = new KisilerDaoRepository();

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel){
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel);
    }

}
