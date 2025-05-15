package com.example.dragdropteknesne;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RelativeLayout relativeLayout;

    private static final String BUTTON_ETIKET = "DRAG BUTTON";

    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setTag(BUTTON_ETIKET);

        relativeLayout = findViewById(R.id.rl);
    }
}