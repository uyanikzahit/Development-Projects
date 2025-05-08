package com.example.rehberuygulamasi.room;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;
import com.example.rehberuygulamasi.data.entity.Kisiler;

@Dao
public interface KisilerDao {
    @Query("SELECT * FROM `kisiler `")
    Single<List<Kisiler>> tumKisiler();
}
