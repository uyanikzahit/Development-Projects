package com.example.a2doyun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SonucEkraniActivity extends AppCompatActivity {

    private TextView textViewToplamSkor;
    private TextView textViewEnYuksekSkor;
    private Button buttonTekrarDene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc_ekrani);

        textViewToplamSkor = findViewById(R.id.textViewToplamSkor);
        textViewEnYuksekSkor = findViewById(R.id.textViewEnYuksekSkor);
        buttonTekrarDene = findViewById(R.id.buttonTekrarDene);

        buttonTekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (SonucEkraniActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}