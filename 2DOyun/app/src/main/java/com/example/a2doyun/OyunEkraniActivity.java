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
import java.util.Map;
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

    private int saridaireX;
    private int saridaireY;

    private int siyahkareX;
    private int siyahkareY;

    private int kirmiziucgenX;
    private int kirmiziucgenY;


    private int skor = 0;


    //Boyutlar
    private int ekranGenisligi;
    private int ekranYuksekligi;
    private int anakarakterGenisligi;
    private int anakarakterYuksekligi;

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
        kirmiziucgen = findViewById(R.id.kirmiziucgen);


        //Cisimleri ekranın dışına çıkarma
        siyahkare.setX(-80);
        siyahkare.setY(-80);
        saridaire.setX(-80);
        saridaire.setY(-80);
        kirmiziucgen.setX(-80);
        kirmiziucgen.setY(-80);

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

                    textViewOyunaBasla.setVisibility(View.INVISIBLE);

                    anakarakterX =(int) anakarakter.getX();
                    anakarakterY =(int) anakarakter.getY();

                    anakarakterGenisligi = anakarakter.getWidth();
                    anakarakterYuksekligi = anakarakter.getHeight();
                    ekranGenisligi = cl.getWidth();
                    ekranYuksekligi = cl.getHeight();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    anakarakterHaraketEttirme();
                                    cisimleriHareketEttir();
                                    carpismaKontrol();
                                }
                            });

                        }
                    },0,20);
                }


                return true;
            }
        });


    }
    public void anakarakterHaraketEttirme(){
        if(dokunmaKontrol){
            anakarakterY-=20;
        }else{
            anakarakterY+=20;
        }

        if(anakarakterY <= 0){
            anakarakterY = 0;
        }
        if(anakarakterY >= ekranYuksekligi - anakarakterYuksekligi){
            anakarakterY = ekranYuksekligi - anakarakterYuksekligi;
        }
        anakarakter.setY(anakarakterY);
    }

    public void cisimleriHareketEttir(){

        siyahkareX-=15;
        if(siyahkareX <0){
            siyahkareX = ekranGenisligi +20;
            siyahkareY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        siyahkare.setX(siyahkareX);
        siyahkare.setY(siyahkareY);

        saridaireX-=20;
        if(saridaireX <0){
            saridaireX = ekranGenisligi +20;
            saridaireY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        saridaire.setX(saridaireX);
        saridaire.setY(saridaireY);


        kirmiziucgenX-=25;
        if(kirmiziucgenX <0){
            kirmiziucgenX = ekranGenisligi +20;
            kirmiziucgenY = (int) Math.floor(Math.random() * ekranYuksekligi);
        }

        kirmiziucgen.setX(kirmiziucgenX);
        kirmiziucgen.setY(kirmiziucgenY);
    }

    public void carpismaKontrol(){
        int saridaireMerkezX = saridaireX+ saridaire.getWidth()/2;
        int saridaireMerkezY = saridaireY+ saridaire.getHeight()/2;

        if(0<= saridaireMerkezX && saridaireMerkezX<=anakarakterGenisligi && anakarakterY <=saridaireMerkezY
                && saridaireMerkezY <= anakarakterY+anakarakterYuksekligi){

            skor+=20;
            saridaireX = -10;
        }



        int kirmiziucgenMerkezX = kirmiziucgenX+ kirmiziucgen.getWidth()/2;
        int kirmiziucgenMerkezY = kirmiziucgenY+ kirmiziucgen.getHeight()/2;

        if(0<= kirmiziucgenMerkezX && kirmiziucgenMerkezX<=anakarakterGenisligi && anakarakterY <=kirmiziucgenMerkezY
                && kirmiziucgenMerkezY <= anakarakterY+anakarakterYuksekligi){

            skor+=50;
            kirmiziucgenX = -10;
        }



        int siyahkareMerkezX = siyahkareX+ siyahkare.getWidth()/2;
        int siyahkareMerkezY = siyahkareY+ siyahkare.getHeight()/2;

        if(0<= siyahkareMerkezX && siyahkareMerkezX<=anakarakterGenisligi && anakarakterY <=siyahkareMerkezY
                && siyahkareMerkezY <= anakarakterY+anakarakterYuksekligi){

            siyahkareX = -10;

            //Timer durdur
            timer.cancel();
            timer=null;

            Intent intent = new Intent(OyunEkraniActivity.this,SonucEkraniActivity.class);
            intent.putExtra("skor", skor);
            startActivity(intent);
        }
        textViewSkor.setText(String.valueOf(skor));
    }
}