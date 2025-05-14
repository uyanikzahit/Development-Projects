package com.example.animasyonuygulamasi;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ımageView;
    private TextView textView;
    private Button button;

    private Animation downstop;
    private Animation uptodown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ımageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        downstop = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        uptodown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);

        button.setAnimation(downstop);
        textView.setAnimation(uptodown);
        ımageView.setAnimation(uptodown);

    }
}