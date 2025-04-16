package com.example.firebasecalismasi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("kisiler");

//        Kisiler kisi1= new Kisiler("","Ahmet",18);
//        Kisiler kisi2= new Kisiler("","Mehmet",11);
//        Kisiler kisi3= new Kisiler("","Seda",10);
//        Kisiler kisi4= new Kisiler("","Faruk",25);
//        Kisiler kisi5= new Kisiler("","Celal",52);
//        Kisiler kisi6= new Kisiler("","Hilmi",31);
//        Kisiler kisi7= new Kisiler("","Aysun",36);
//
//        myRef.push().setValue(kisi1);
//        myRef.push().setValue(kisi2);
//        myRef.push().setValue(kisi3);
//        myRef.push().setValue(kisi4);
//        myRef.push().setValue(kisi5);
//        myRef.push().setValue(kisi6);
//        myRef.push().setValue(kisi7);


//        myRef.child("-ONyANaXB94P7pHxCd4-").removeValue();

        Map<String, Object> bilgiler = new HashMap<>();
        bilgiler.put("kisi_ad","CEYLANNN");
        bilgiler.put("kisi_yas",99);

        myRef.child("-ONyANak-W7JrE4jqF6L").updateChildren(bilgiler);

    }
}