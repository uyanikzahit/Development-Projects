    package com.example.a2doyun;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

    public class OyunEkraniActivity extends AppCompatActivity {
    private ConstraintLayout cl;
    private TextView textViewSkor;
    private TextView textViewOyunaBasla;
    private ImageView anakarakter;
    private ImageView saridaire;
    private ImageView siyahkare;
    private ImageView kirmiziucgen;


    //Pozisyonlar
    private int anakarakterX;
    private int anakarakterY;

    //Kontroller
    private boolean dokunmaKontrol = false;
    private boolean baslangicKontrol = false;

    private Timer timer = new Timer();
    private Handler handler = new Handler();



    @SuppressLint("ClickableViewAccessibility")
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


        cl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if(baslangicKontrol){
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                        Log.e("MotionEvent","Ekrana dokunuldu");
                        dokunmaKontrol = true;
                    }

                    if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                        Log.e("MotionEvent","Ekranı bıraktı");
                        dokunmaKontrol = false;

                    }
                }else{
                    baslangicKontrol = true;

                    anakarakterX =(int) anakarakter.getX();
                    anakarakterY =(int) anakarakter.getY();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if(dokunmaKontrol){
                                        anakarakterY-=20;
                                    }else{
                                        anakarakterY+=20;
                                    }
                                    anakarakter.setY(anakarakterY);

                                }
                            });

                        }
                    },0,20);
                }


                return true;
            }
        });


    }
}