package com.example.daggerkullanimi;

import android.util.Log;

public class Kargo {

    Adres adres = new Adres("Saimbeyli/Adana");

    public void gonder () {
        Log.e("Sonuç", "Kargo " + adres.getAdresBilgisi()+" adresine gönderildi");
    }
}
