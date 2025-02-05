package com.example.numberguessingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private  int sayac = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tahmin);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random r = new Random();

        rastgeleSayi = r.nextInt(101); //0-100
        Log.e("Rastgele Sayi", String.valueOf(rastgeleSayi));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayac = sayac - 1;
                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                if(tahmin == rastgeleSayi){

                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc", true);
                    startActivity(i);
                    finish();
                    return;
                }

                if(tahmin > rastgeleSayi){
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak: "+sayac);
                }

                if(tahmin < rastgeleSayi){
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak: "+sayac);
                }

                if(sayac == 0){
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc", false);
                    startActivity(i);
                    finish();
                }

                editTextGirdi.setText("");


            }
        });

    }
}