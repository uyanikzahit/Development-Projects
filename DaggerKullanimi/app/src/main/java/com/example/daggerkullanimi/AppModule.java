package com.example.daggerkullanimi;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public Adres provideAdres(){
        return new Adres("Saimbeyli/Adana");

    }
}
