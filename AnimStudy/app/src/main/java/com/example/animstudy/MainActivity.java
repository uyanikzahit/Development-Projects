package com.example.animstudy;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button,buttonYap;

    private Animation animasyon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonYap = findViewById(R.id.buttonYap);

        animasyon = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ayniancalismasi);

        buttonYap.setOnClickListener((view) ->{
            button.startAnimation(animasyon);
        });

    }
}