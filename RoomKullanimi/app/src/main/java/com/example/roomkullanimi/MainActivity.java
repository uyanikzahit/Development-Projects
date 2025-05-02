package com.example.roomkullanimi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Veritabani vt;
    private KisilerDao kdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        vt = Veritabani.veritabaniErisim(this);
        kdao = vt.getKisilerDao();

//      ekle();
//      guncelle();
//      sil();
//      kisileriYukle();
//      rastgele();
//        ara();
//getir();
        kontrol();
    }

    public void kisileriYukle(){
        kdao.tumKisiler().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        for(Kisiler k:kisilers){
                            Log.e("Kişi id",String.valueOf(k.getKisi_id()));
                            Log.e("Kişi ad",k.getKisi_ad());
                            Log.e("Kişi yaş",String.valueOf(k.getKisi_yas()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void ekle(){
        Kisiler yeniKisi = new Kisiler(0,"Zahit",24);

        kdao.kisiEkle(yeniKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });

    }


    public void guncelle(){
        Kisiler guncellenenKisi = new Kisiler(3,"New Zahit",25);

        kdao.kisiGuncelle(guncellenenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });

    }

    public void sil(){
        Kisiler silinenKisi = new Kisiler(3,"New Zahit",25);

        kdao.kisiSil(silinenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });

    }

    public void rastgele(){
        kdao.rastgele1KisiGetir().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        for(Kisiler k:kisilers){
                            Log.e("Kişi id",String.valueOf(k.getKisi_id()));
                            Log.e("Kişi ad",k.getKisi_ad());
                            Log.e("Kişi yaş",String.valueOf(k.getKisi_yas()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }


    public void ara(){
        kdao.kisiAra("c").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        for(Kisiler k:kisilers){
                            Log.e("Kişi id",String.valueOf(k.getKisi_id()));
                            Log.e("Kişi ad",k.getKisi_ad());
                            Log.e("Kişi yaş",String.valueOf(k.getKisi_yas()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void getir(){
        kdao.kisiGetir(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Kisiler>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(Kisiler kisiler) {

                        Log.e("Kişi id",String.valueOf(kisiler.getKisi_id()));
                        Log.e("Kişi ad",kisiler.getKisi_ad());
                        Log.e("Kişi yaş",String.valueOf(kisiler.getKisi_yas()));

                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kontrol() {
        kdao.kayitKontrol("ali").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(Integer integer) {
                        Log.e("Kişi kayıt kontrol",String.valueOf(integer));

                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
}