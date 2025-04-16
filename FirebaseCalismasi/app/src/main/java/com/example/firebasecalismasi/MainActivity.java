package com.example.firebasecalismasi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("kisiler");

/*        Kisiler kisi1= new Kisiler("","Ahmet",18);
        Kisiler kisi2= new Kisiler("","Mehmet",11);
        Kisiler kisi3= new Kisiler("","Seda",10);
        Kisiler kisi4= new Kisiler("","Faruk",25);
        Kisiler kisi5= new Kisiler("","Celal",52);
        Kisiler kisi6= new Kisiler("","Hilmi",31);
        Kisiler kisi7= new Kisiler("","Aysun",36);

        myRef.push().setValue(kisi1);
        myRef.push().setValue(kisi2);
        myRef.push().setValue(kisi3);
        myRef.push().setValue(kisi4);
        myRef.push().setValue(kisi5);
        myRef.push().setValue(kisi6);
        myRef.push().setValue(kisi7);


        myRef.child("-ONyANaXB94P7pHxCd4-").removeValue();*/

/*        Map<String, Object> bilgiler = new HashMap<>();
        bilgiler.put("kisi_ad","CEYLANNN");
        bilgiler.put("kisi_yas",99);

        myRef.child("-ONyANak-W7JrE4jqF6L").updateChildren(bilgiler);*/

//        Query kisilerSorgu = myRef.orderByChild("kisi_yas").equalTo(11);
        Query kisilerSorgu = myRef.limitToFirst(3);
        kisilerSorgu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot d:snapshot.getChildren()){
                    Kisiler kisi = d.getValue(Kisiler.class);
                    String key = d.getKey();
                    kisi.setKisi_key(key);

                    Log.e("**********","******");
                    Log.e("kisi_key",kisi.getKisi_key());
                    Log.e("kisi_ad",kisi.getKisi_ad());
                    Log.e("kisi_yas",String.valueOf(kisi.getKisi_yas()));
                    Log.e("**********","******");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}