package com.example.rehberuygulamasi.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import com.example.rehberuygulamasi.data.entity.Kisiler;


@Dao
public interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    Single<List<Kisiler>> tumKisiler();

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%'|| :aramaKelimesi ||'%'")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Delete
    Completable kisiSil(Kisiler kisi);

    @Insert
    Completable kisiEkle(Kisiler kisi);
    @Update
    Completable kisiGuncelle(Kisiler kisi);
}
