package com.example.roomkullanimi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("SELECT * FROM kisiler" )
    Single<List<Kisiler>> tumKisiler();
    @Insert
    Completable kisiEkle(Kisiler kisi);

    @Update
    Completable kisiGuncelle(Kisiler kisi);

    @Delete
    Completable kisiSil(Kisiler kisi);

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1")
    Single<List<Kisiler>> rastgele1KisiGetir();

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%'|| :aramaKelimesi||'%'")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Query("SELECT * FROM kisiler WHERE kisi_id=:kisi_id" )
    Single<Kisiler> kisiGetir(int kisi_id);

    @Query("SELECT count(*) FROM kisiler WHERE kisi_ad=:kisi_ad" )
    Single<Integer> kayitKontrol(String  kisi_ad);
}

