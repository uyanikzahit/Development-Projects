package com.example.dragdropcoklunesne;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
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
    public boolean onDrag(View view, DragEvent dragEvent) {

        switch (dragEvent.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                view.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                view.getBackground().clearColorFilter();
                view.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                view.getBackground().clearColorFilter();
                view.invalidate();

                View gorselNesne = (View) dragEvent.getLocalState();

                ViewGroup eskiTasarimAlani = (ViewGroup) gorselNesne.getParent();

                eskiTasarimAlani.removeView(gorselNesne);

                LinearLayout hedefTasarimAlani = (LinearLayout) view;

                hedefTasarimAlani.addView(gorselNesne);

                gorselNesne.setVisibility(View.VISIBLE);

                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                view.getBackground().clearColorFilter();
                view.invalidate();
                return true;
            default:break;
        }

        return false;
    }

    @Override
    public boolean onLongClick(View view) {

        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String [] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData clipData = new ClipData(view.getTag().toString(),mimeTypes,item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(clipData,shadowBuilder,view,0);

        view.setVisibility(View.INVISIBLE);
        return true;
    }
}