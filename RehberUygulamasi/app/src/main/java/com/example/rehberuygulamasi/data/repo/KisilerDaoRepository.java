package com.example.rehberuygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.rehberuygulamasi.data.entity.Kisiler;

import java.util.ArrayList;
import java.util.List;

import com.example.rehberuygulamasi.room.*;

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
        Log.e("Kişi Kayıt",kisi_ad+" - "+kisi_tel);
    }

    public void kisiGuncelle(int kisi_id, String kisi_ad, String kisi_tel){
        Log.e("Kişi Güncelle",kisi_id +" - "+ kisi_ad+" - "+kisi_tel);
    }

    public void kisiAra(String aramaKelimesi){
        Log.e("Kişi Ara", aramaKelimesi);
    }

    public void kisiSil (int kisi_id){
        Log.e("Kişi Sil",String.valueOf(kisi_id));

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
