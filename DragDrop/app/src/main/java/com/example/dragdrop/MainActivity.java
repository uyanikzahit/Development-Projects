package com.example.dragdrop;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonKopyala, buttonGit;
    private EditText editText;

    private ClipboardManager kopyalamaPanom;
    private ClipData clipData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonKopyala = findViewById(R.id.buttonKopyala);
        buttonGit = findViewById(R.id.buttonGit);
        editText = findViewById(R.id.editText);

        kopyalamaPanom = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        buttonKopyala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kopyalanacakYazi  = editText.getText().toString();
                clipData = ClipData.newPlainText("text",kopyalanacakYazi);

                kopyalamaPanom.setPrimaryClip(clipData);

                Toast.makeText(getApplicationContext(), "Panoya Kopyalandır",Toast.LENGTH_SHORT).show();


            }
        });

        buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        });

    }
}