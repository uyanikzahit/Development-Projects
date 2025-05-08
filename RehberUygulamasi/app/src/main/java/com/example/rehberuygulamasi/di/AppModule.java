package com.example.rehberuygulamasi.di;

import android.content.Context;

import androidx.room.Room;

import com.example.rehberuygulamasi.data.repo.KisilerDaoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import com.example.rehberuygulamasi.room.*;


@Module

//Bir nesnenin her yerden erişilmesini sağlayan yapıdır.
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kdao){
        return new KisilerDaoRepository(kdao);
    }

    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class,"rehber.sqlite")
                .createFromAsset("rehber.sqlite").build();
        return vt.getKisilerDao();
    }
}
