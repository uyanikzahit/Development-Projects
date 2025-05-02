package com.example.daggerkullanimi;

import android.util.Log;

public class Internet {

    Adres adres = new Adres("Saimbeyli/Adana");

    public void basvuruYap () {
        Log.e("Sonuç", "İnternet başvurusu " + adres.getAdresBilgisi()+" adres için yapıldı");
    }
}
