package com.example.daggerkullanimi;

import android.util.Log;

import javax.inject.Inject;

public class Kargo {


    private Adres adres;

    @Inject
    public Kargo(Adres adres) {
        this.adres = adres;
    }

    public void gonder () {
        Log.e("Sonuç", "Kargo " + adres.getAdresBilgisi()+" adresine gönderildi");
    }
}
