package com.example.rehberuygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.rehberuygulamasi.data.entity.Kisiler;

import java.util.ArrayList;
import java.util.List;

import com.example.rehberuygulamasi.room.*;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    private MutableLiveData<List<Kisiler>> kisilerListesi;
    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao) {
        this.kdao = kdao;
        kisilerListesi = new MutableLiveData();
    }

    public MutableLiveData<List<Kisiler>>kisileriGetir(){
        return kisilerListesi;
    }

    public void kisiKayit(String kisi_ad, String kisi_tel){
        Kisiler yeniKisi = new Kisiler("0",kisi_ad,kisi_tel);
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

    public void kisiGuncelle(String kisi_id, String kisi_ad, String kisi_tel){
        Kisiler guncellenenKisi = new Kisiler(kisi_id,kisi_ad,kisi_tel);
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

    public void kisiAra(String aramaKelimesi){

        kdao.kisiAra(aramaKelimesi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {

                        kisilerListesi.setValue(kisilers);

                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kisiSil (String kisi_id){
        Kisiler silinenKisi = new Kisiler(kisi_id,"","");
        kdao.kisiSil(silinenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override

                    public void onComplete() {
                        tumKisileriAl();
                    }

                    @Override
                    public void onError(Throwable e) {}
                });

    }

    public void tumKisileriAl(){
       kdao.tumKisiler().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<List<Kisiler>>() {
                   @Override
                   public void onSubscribe(Disposable d) {}
                   @Override
                   public void onSuccess(List<Kisiler> kisilers) {

                       kisilerListesi.setValue(kisilers);

                   }
                   @Override
                   public void onError(Throwable e) {}
               });
    }
}
