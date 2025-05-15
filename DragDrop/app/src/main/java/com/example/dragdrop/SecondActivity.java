package com.example.dragdrop;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private ClipboardManager kopyalamaPanom;
    private ClipData clipData;
    private Button buttonYapistir;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);


        buttonYapistir = findViewById(R.id.buttonYapistir);
        textView = findViewById(R.id.textView);


        kopyalamaPanom = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        buttonYapistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clipData = kopyalamaPanom.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                String kopyalanmisYazi = item.getText().toString();

                textView.setText(kopyalanmisYazi);

                Toast.makeText(getApplicationContext(), "Yazı Yapıştırıldı",Toast.LENGTH_SHORT).show();

            }
        });


    }
}