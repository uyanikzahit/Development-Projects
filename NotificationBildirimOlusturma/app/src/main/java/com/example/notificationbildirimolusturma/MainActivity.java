package com.example.notificationbildirimolusturma;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonBildir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonBildir = (Button) findViewById(R.id.buttonBildir);

        buttonBildir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                durumaBagli(); // Butona tıklanınca bildirim fonksiyonunu çağır
            }
        });

    }

    public void durumaBagli() {
        NotificationManager bildirimYoneticisi = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(MainActivity.this, KarsilamaEkraniActivity.class);

        PendingIntent gidilecekIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder; // Builder'ı baştan tanımlıyoruz

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String kanalId = "kanalId";
            String kanalAd = "kanalAd";
            String kanalTanim = "kanalTanim";
            int kanalOnceligi = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel kanal = bildirimYoneticisi.getNotificationChannel(kanalId);

            if (kanal == null) {
                kanal = new NotificationChannel(kanalId, kanalAd, kanalOnceligi);
                kanal.setDescription(kanalTanim);
                bildirimYoneticisi.createNotificationChannel(kanal);
            }

            builder = new NotificationCompat.Builder(this, kanalId);

        } else {
            builder = new NotificationCompat.Builder(this);
        }

        // Ortak bildirim ayarları
        builder.setContentTitle("Başlık")
                .setContentText("İçerik")
                .setSmallIcon(R.drawable.resim)
                .setAutoCancel(true)
                .setContentIntent(gidilecekIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH); // Hata düzeltilmiş hali

        bildirimYoneticisi.notify(1, builder.build()); // Bildirimi göster
    }
}
