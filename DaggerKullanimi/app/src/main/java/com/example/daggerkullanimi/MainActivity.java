package com.example.daggerkullanimi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Kargo kargo;
    @Inject
    Internet internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder().build().inject(this);

        kargo.gonder();

        internet.basvuruYap();

    }
}