package com.example.numberguessingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SonucActivity extends AppCompatActivity {

    private TextView textViewSonuc;

    private ImageView imageViewSonuc;
    private Button buttonTekrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc);

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivities(new Intent[]{new Intent(SonucActivity.this, TahminActivity.class)});
                finish();

            }
        });



    }
}