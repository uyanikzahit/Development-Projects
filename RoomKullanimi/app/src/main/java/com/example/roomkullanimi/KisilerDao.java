package com.example.roomkullanimi;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("SELECT * FROM kisiler" )
    Single<List<Kisiler>> tumKisiler();
}
