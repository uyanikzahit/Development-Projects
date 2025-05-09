package com.example.rehberuygulamasi.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "kisiler")
public class Kisiler implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisi_id")
    @NotNull
    private String kisi_id;
    @ColumnInfo(name = "kisi_ad")
    @NotNull
    private String kisi_ad;
    @ColumnInfo(name = "kisi_tel")
    @NotNull
    private String kisi_tel;


    public Kisiler() {
    }

    public Kisiler(@NotNull String kisi_id, @NotNull String kisi_ad, @NotNull String kisi_tel) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;
        this.kisi_tel = kisi_tel;
    }

    public @NotNull String getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(@NotNull String kisi_id) {
        this.kisi_id = kisi_id;
    }

    public @NotNull String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(@NotNull String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public @NotNull String getKisi_tel() {
        return kisi_tel;
    }

    public void setKisi_tel(@NotNull String kisi_tel) {
        this.kisi_tel = kisi_tel;
    }
}
