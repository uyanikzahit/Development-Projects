package com.example.filmleruygulamasi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetayActivity extends AppCompatActivity {
    private ImageView imageViewResim;
    private TextView textViewFilmAdi,textViewYil,textViewYonetmen;

    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detay);

        imageViewResim = findViewById(R.id.imageViewResim);
        textViewFilmAdi = findViewById(R.id.textViewFilmAdi);
        textViewYil = findViewById(R.id.textViewYil);
        textViewYonetmen = findViewById(R.id.textViewYonetmen);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAdi.setText(film.getFilm_ad());
        textViewYil.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmen.setText(film.getYonetmen().getYonetmen_ad());

        imageViewResim.setImageResource(getResources().getIdentifier(film.getFilm_resim(),
                "drawable",getPackageName()));


    }
}