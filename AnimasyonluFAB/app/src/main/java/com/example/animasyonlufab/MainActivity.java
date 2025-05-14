package com.example.animasyonlufab;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain, fabBirinci, fabIkinci;
    private Animation fabacik, fabkapali, afterturn, nextturn;
    private Boolean fabDurum = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fabMain);
        fabBirinci = findViewById(R.id.fabBirinci);
        fabIkinci = findViewById(R.id.fabIkinci);


        fabacik = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fabacik);
        fabkapali = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fabkapali);
        afterturn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.afterturn);
        nextturn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nextturn);

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fabDurum){
                    //tıklanıldığında kapansın

                    fabMain.startAnimation(afterturn);
                    fabBirinci.startAnimation(fabkapali);
                    fabIkinci.startAnimation(fabkapali);
                    fabBirinci.setClickable(false);
                    fabIkinci.setClickable(false);
                    fabDurum = false;

                }else{
                    //tıklanıldığında açılsın

                    fabMain.startAnimation(nextturn);
                    fabBirinci.startAnimation(fabacik);
                    fabIkinci.startAnimation(fabacik);
                    fabBirinci.setClickable(true);
                    fabIkinci.setClickable(true);
                    fabDurum = true;
                }
            }
        });


    }
}