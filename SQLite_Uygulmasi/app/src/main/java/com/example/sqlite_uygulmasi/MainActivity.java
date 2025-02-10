package com.example.sqlite_uygulmasi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VeriTabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        vt = new VeriTabaniYardimcisi(this);

        new Kelimelerdao().kelimeEkle(vt,"door","kapı");
        new Kelimelerdao().kelimeEkle(vt,"necessrey","gerekli");
        new Kelimelerdao().kelimeEkle(vt,"want","istemek");
        new Kelimelerdao().kelimeEkle(vt,"taste","tadı olmak");
        new Kelimelerdao().kelimeEkle(vt,"think","düşünmek");


        ArrayList<Kelimeler> gelenKelimelerListesi = new Kelimelerdao().tumKelimeler(vt);

        for(Kelimeler k : gelenKelimelerListesi){

            Log.e(String.valueOf(k.getKelime_id()),k.getIngilizce()+" - "+k.getTurkce());
        }



    }
}