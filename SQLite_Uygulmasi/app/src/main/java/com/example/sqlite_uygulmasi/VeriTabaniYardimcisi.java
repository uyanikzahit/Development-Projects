package com.example.sqlite_uygulmasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VeriTabaniYardimcisi extends SQLiteOpenHelper {

    public VeriTabaniYardimcisi(@Nullable Context context) {
        super(context, "sozluk", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kelimeler ( " +
                "kelime_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ingilizce TEXT, " +
                "turkce TEXT " +
                ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS kelimeler");
    onCreate(db);
    }
}
