package com.example.roomkullanimi;

import androidx.room.Dao;
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
}
