package com.example.filmleruygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(@Nullable Context context) {
        super(context, "filmler.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"kategoriler\" (\n" +
                "\t\"kategori_id\"\tINTEGER,\n" +
                "\t\"kategori_ad\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"kategori_id\" AUTOINCREMENT)\n" +
                ");");
        sqLiteDatabase.execSQL();
        sqLiteDatabase.execSQL();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
