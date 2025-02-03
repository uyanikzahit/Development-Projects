package com.example.progressbarseekratingbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button, buttonBasla, buttonDur;
    private ProgressBar progressBar;
    private TextView textViewSonuc;
    private SeekBar seekBar;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonBasla = findViewById(R.id.buttonBasla);
        buttonDur = findViewById(R.id.buttonDur);
        progressBar = findViewById(R.id.progressBar);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        seekBar = findViewById(R.id.seekBar);
        ratingBar = findViewById(R.id.ratingBar);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

            }
        });

        buttonDur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSonuc.setText("Sonuç: "+i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float gelenOylama = ratingBar.getRating();
//                int gelenIlerleme = seekBar.getProgress();

                Log.e("Oylama sonucu",String.valueOf(gelenOylama));
//                Log.e("İlerleme sonucu",String.valueOf(gelenIlerleme));


            }
        });

    }
}