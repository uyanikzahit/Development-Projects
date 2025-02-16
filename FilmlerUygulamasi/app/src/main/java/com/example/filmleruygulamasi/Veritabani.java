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
                "    \"kategori_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    \"kategori_ad\" TEXT\n" +
                ");\n");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"yonetmenler\" (\n" +
                "    \"yonetmen_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    \"yonetmen_ad\" TEXT\n" +
                ");\n");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"filmler\" (\n" +
                "    \"film_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    \"film_ad\" TEXT,\n" +
                "    \"film_yil\" INTEGER,\n" +
                "    \"film_resim\" TEXT,\n" +
                "    \"kategori_id\" INTEGER,\n" +
                "    \"yonetmen_id\" INTEGER,\n" +
                "    FOREIGN KEY(\"kategori_id\") REFERENCES \"kategoriler\"(\"kategori_id\"),\n" +
                "    FOREIGN KEY(\"yonetmen_id\") REFERENCES \"yonetmenler\"(\"yonetmen_id\")\n" +
                ");\n");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kategoriler");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS yonetmenler");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS filmler");

        onCreate(sqLiteDatabase);

    }
}
