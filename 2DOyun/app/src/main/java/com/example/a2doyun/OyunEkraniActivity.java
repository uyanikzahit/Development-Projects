    package com.example.a2doyun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OyunEkraniActivity extends AppCompatActivity {
    private ConstraintLayout cl;
    private TextView textViewSkor;
    private TextView textViewOyunaBasla;
    private ImageView anakarakter;
    private ImageView saridaire;
    private ImageView siyahkare;
    private ImageView kirmiziucgen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oyun_ekrani);

        cl = findViewById(R.id.cl);
        textViewSkor = findViewById(R.id.textViewSkor);
        textViewOyunaBasla = findViewById(R.id.textViewOyunaBasla);
        anakarakter = findViewById(R.id.anakarakter);
        saridaire = findViewById(R.id.saridaire);
        siyahkare = findViewById(R.id.siyahkare);
        kirmiziucgen = findViewById(R.id.kirmiziucgen);

        textViewOyunaBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OyunEkraniActivity.this, SonucEkraniActivity .class));
                finish();

            }
        });


    }
}