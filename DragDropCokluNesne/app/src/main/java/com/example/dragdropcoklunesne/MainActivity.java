package com.example.dragdropcoklunesne;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    private TextView textView;
    private Button button;
    private ImageView imageView;

    private LinearLayout ust_tasarim;
    private LinearLayout sol_tasarim;
    private LinearLayout sag_tasarim;

    private static final String YAZI_ETIKET = "YAZI";
    private static final String BUTTON_ETIKET = "BUTTON";
    private static final String RESIM_ETIKET = "RESİM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ust_tasarim = findViewById(R.id.ust_tasarim);
        sol_tasarim = findViewById(R.id.sol_tasarim);
        sag_tasarim = findViewById(R.id.sag_tasarim);


        textView = findViewById(R.id.textView);
        textView.setTag(YAZI_ETIKET);
        button = findViewById(R.id.button);
        button.setTag(BUTTON_ETIKET);
        imageView = findViewById(R.id.imageView);
        imageView.setTag(RESIM_ETIKET);


        textView.setOnLongClickListener(this);
        button.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);

        ust_tasarim.setOnDragListener(this);
        sol_tasarim.setOnDragListener(this);
        sag_tasarim.setOnDragListener(this);

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}