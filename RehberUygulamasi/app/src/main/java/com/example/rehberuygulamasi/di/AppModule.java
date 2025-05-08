package com.example.rehberuygulamasi.di;

import com.example.rehberuygulamasi.data.repo.KisilerDaoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module

//Bir nesnenin her yerden erişilmesini sağlayan yapıdır.
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(){
        return new KisilerDaoRepository();
    }
}
