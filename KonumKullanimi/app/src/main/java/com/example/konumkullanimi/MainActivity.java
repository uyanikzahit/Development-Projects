package com.example.konumkullanimi;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.konumkullanimi.databinding.ActivityMainBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;
    private int izinKontrol= 0;
    private FusedLocationProviderClient flpc;
    private Task<Location> locationTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        flpc = LocationServices.getFusedLocationProviderClient(this);


        tasarim.buttonKonumAl.setOnClickListener(view ->{
            izinKontrol = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

            if(izinKontrol != PackageManager.PERMISSION_GRANTED){//İzin onaylanmamışsa.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);

            }else{//İzin onaylanmışsa.
                locationTask = flpc.getLastLocation();
                konumBilgisiAl();

            }
        });

    }

    public void konumBilgisiAl(){
        locationTask.addOnSuccessListener(location -> {
            if(location !=null){
                tasarim.textViewEnlem.setText("Enlem: "+ location.getLatitude());
                tasarim.textViewBoylam.setText("Boylam: "+ location.getLongitude());

            }else{
                tasarim.textViewEnlem.setText("Enlem: Alınamadı.");
                tasarim.textViewBoylam.setText("Boylam: Alınamadı.");

            }
        });
    }

    @Override
    @SuppressLint("MissingSuperCall")
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 100){

            izinKontrol = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"İzin kabul edildi.",Toast.LENGTH_SHORT).show();
                locationTask = flpc.getLastLocation();
                konumBilgisiAl();
            }else{
                Toast.makeText(getApplicationContext(),"İzin reddedildi",Toast.LENGTH_SHORT).show();

            }

        }
    }
}
