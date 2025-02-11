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

        int kelimeIdIndex = c.getColumnIndex("kelime_id");
        int ingilizceIndex = c.getColumnIndex("ingilizce");
        int turkceIndex = c.getColumnIndex("turkce");

        while (c.moveToNext()) {
            if (kelimeIdIndex >= 0 && ingilizceIndex >= 0 && turkceIndex >= 0) {
                Kelimeler kelimeler = new Kelimeler(
                        c.getInt(kelimeIdIndex),
                        c.getString(ingilizceIndex),
                        c.getString(turkceIndex)
                );
            }
        }
        return kelimelerArrayList;
    }

    public void kelimeSil(VeriTabaniYardimcisi vt, int kelime_id){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("kelimeler","kelime_id=?",new String[]{String.valueOf(kelime_id)});
        dbx.close();
    }


    public void kelimeGuncelle(VeriTabaniYardimcisi vt, int kelime_id, String ingilizce, String turkce){

        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce",ingilizce);
        degerler.put("turkce",turkce);

        dbx.update("kelimeler",degerler,"kelime_id=?", new String[]{String.valueOf(kelime_id)});
        dbx.close();
    }
}
