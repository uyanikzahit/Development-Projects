package com.example.filmleruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FilmlerDao {
    public ArrayList<Filmler> tumFilmlerByKategoriId(Veritabani vt, int kategori_id){

        ArrayList<Filmler> filmlerArrayList =  new ArrayList<>();

        SQLiteDatabase db  = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM filmler,kategoriler,yonetmenler WHERE filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id = yonetmenler.yonetmen_id and filmler.kategori_id="+kategori_id, null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                    ,c.getString(c.getColumnIndexOrThrow("kategori_ad")));

            Yonetmenler y = new Yonetmenler(c.getInt(c.getColumnIndexOrThrow("yonetmen_id"))
                    ,c.getString(c.getColumnIndexOrThrow("yonetmen_ad")));

            Filmler f = new Filmler(c.getInt(c.getColumnIndexOrThrow("film_id"))
            ,c.getString(c.getColumnIndexOrThrow("film_ad"))
            ,c.getInt(c.getColumnIndexOrThrow("film_yil"))
            ,c.getString(c.getColumnIndexOrThrow("film_resim")),k,y);

            filmlerArrayList.add(f);

        }
        return filmlerArrayList;
    }
}
