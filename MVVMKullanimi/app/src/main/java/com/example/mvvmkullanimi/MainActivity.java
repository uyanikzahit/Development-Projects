package com.example.mvvmkullanimi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewSonuc;
    private EditText editTextSayi1, editTextSayi2;
    private Button buttonToplama, buttonCarpma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewSonuc = findViewById(R.id.textViewSonuc);
        editTextSayi1 = findViewById(R.id.editTextSayi1);
        editTextSayi2 = findViewById(R.id.editTextSayi2);
        buttonToplama = findViewById(R.id.buttonToplama);
        buttonCarpma = findViewById(R.id.buttonCarpma);

        textViewSonuc.setText("0");

        buttonToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alinanSayi1 = editTextSayi1.getText().toString();
                String alinanSayi2 = editTextSayi2.getText().toString();

                int sayi1 = Integer.parseInt(alinanSayi1);
                int sayi2 = Integer.parseInt(alinanSayi2);

                int toplam = sayi1 + sayi2;

                textViewSonuc.setText(String.valueOf(toplam));

            }
        });

        buttonCarpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alinanSayi1 = editTextSayi1.getText().toString();
                String alinanSayi2 = editTextSayi2.getText().toString();

                int sayi1 = Integer.parseInt(alinanSayi1);
                int sayi2 = Integer.parseInt(alinanSayi2);

                int carpma = sayi1 * sayi2;

                textViewSonuc.setText(String.valueOf(carpma));

            }
        });

    }
}