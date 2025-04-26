package com.example.mvvmkullanimi;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvmkullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        tasarim.setMainActivityNesnesi(this);
        setContentView(tasarim.getRoot());

        tasarim.textViewSonuc.setText("0");

    }

    public void buttonToplamaTikla(String alinanSayi1,String alinanSayi2){


        // xml tarafında bu kodlamaları yaptığımız için bu bölüme gerek kalmadı
//        String alinanSayi1 = tasarim.editTextSayi1.getText().toString();
//        String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int toplam = sayi1 + sayi2;

        tasarim.textViewSonuc.setText(String.valueOf(toplam));

    }

    public void buttonCarpmaTikla(String alinanSayi1,String alinanSayi2){


        // xml tarafında bu kodlamaları yaptığımız için bu bölüme gerek kalmadı
//        String alinanSayi1 = tasarim.editTextSayi1.getText().toString();
//        String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int carpma = sayi1 * sayi2;

        tasarim.textViewSonuc.setText(String.valueOf(carpma));

    }
}
