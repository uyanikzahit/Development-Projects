package com.example.notlaruygulamasi_design;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv;
    private FloatingActionButton fab;

    private ArrayList<Notlar> notlarArrayList;
    private NotlarAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        notlarArrayList = new ArrayList<>();

        Notlar n1 = new Notlar(1,"Tarih", 50,70);
        Notlar n2 = new Notlar(2,"Türkçe", 60,30);
        Notlar n3 = new Notlar(3,"İngilizce", 90,80);

        notlarArrayList.add(n1);
        notlarArrayList.add(n2);
        notlarArrayList.add(n3);

        adapter = new NotlarAdapter(this,notlarArrayList);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}