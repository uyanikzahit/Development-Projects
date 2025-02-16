package com.example.filmleruygulamasi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView filmlerRv;
    private ArrayList<Filmler>filmlerArrayList;
    private FilmlerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filmler);

        toolbar2 = findViewById(R.id.toolbar2);
        filmlerRv = findViewById(R.id.filmlerRv);

        toolbar2.setTitle("Filmler");
        setSupportActionBar(toolbar2);

        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        filmlerArrayList = new ArrayList<>();

        Filmler f1 = new Filmler(1,"Django",2007,"django",null,null);
        Filmler f2 = new Filmler(2,"Inception",2009,"inception",null,null);
        Filmler f3 = new Filmler(3,"The Pianist",20011,"thepianist",null,null);

        filmlerArrayList.add(f1);
        filmlerArrayList.add(f2);
        filmlerArrayList.add(f3);

        adapter = new FilmlerAdapter(this,filmlerArrayList);
        filmlerRv.setAdapter(adapter);

    }
}