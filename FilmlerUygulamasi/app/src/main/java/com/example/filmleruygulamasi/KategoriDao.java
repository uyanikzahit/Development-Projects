package com.example.filmleruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {
    public ArrayList<Kategoriler> tumKategoriler(Veritabani vt){

        ArrayList<Kategoriler> kategorilerArrayList =  new ArrayList<>();

        SQLiteDatabase db  = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kategoriler", null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                ,c.getString(c.getColumnIndexOrThrow("kategori_ad")));

            kategorilerArrayList.add(k);

        }
        return kategorilerArrayList;
    }
}
