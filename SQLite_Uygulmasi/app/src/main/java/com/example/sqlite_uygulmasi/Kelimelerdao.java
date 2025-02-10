package com.example.sqlite_uygulmasi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Kelimelerdao {
    public void kelimeEkle(VeriTabaniYardimcisi vt, String ingilizce, String turkce){

        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce",ingilizce);
        degerler.put("turkce",turkce);

        dbx.insertOrThrow("kelimeler",null,degerler);
        dbx.close();
    }
    public ArrayList<Kelimeler> tumKelimeler(VeriTabaniYardimcisi vt){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler",null);

        while (c.moveToNext()) {
            Kelimeler kelimeler = new Kelimeler(
                    c.getInt(c.getColumnIndexOrThrow("kelime_id")),
                    c.getString(c.getColumnIndexOrThrow("ingilizce")),
                    c.getString(c.getColumnIndexOrThrow("turkce"))
            );
        }


            kelimelerArrayList.add(kelime);
        }

        return kelimelerArrayList;

    }
}
