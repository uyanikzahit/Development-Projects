package com.example.roomkullanimi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity (tableName = "kisiler")
public class Kisiler {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisi_id")
    @NotNull
    private int kisi_id;
    @ColumnInfo(name = "kisi_ad")
    @NotNull
    private String kisi_ad;
    @ColumnInfo(name = "kisi_yas")
    @NotNull
    private  int kisi_yas;

    public Kisiler() {
    }

    @Ignore
    public Kisiler(@NotNull int kisi_id, @NotNull String kisi_ad, @NotNull int kisi_yas) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;
        this.kisi_yas = kisi_yas;
    }

    @NotNull
    public int getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(@NotNull int kisi_id) {
        this.kisi_id = kisi_id;
    }

    public @NotNull String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(@NotNull String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    @NotNull
    public int getKisi_yas() {
        return kisi_yas;
    }

    public void setKisi_yas(@NotNull int kisi_yas) {
        this.kisi_yas = kisi_yas;
    }
}


