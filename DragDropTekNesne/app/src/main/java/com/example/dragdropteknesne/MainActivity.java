package com.example.dragdropteknesne;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
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

        button.setOnLongClickListener(new View.OnLongClickListener() {
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
        });

        relativeLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams= (RelativeLayout.LayoutParams) button.getLayoutParams();
                        Log.e("Sonuç","ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.e("Sonuç","ACTION_DRAG_ENTERED");
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.e("Sonuç","ACTION_DRAG_EXITED");
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.e("Sonuç","ACTION_DRAG_LOCATION");
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.e("Sonuç","ACTION_DRAG_ENDED");
                        break;
                    case DragEvent.ACTION_DROP:
                        layoutParams.leftMargin=(int) event.getX();
                        layoutParams.topMargin=(int) event.getY();

                        View gorselNesne = (View) event.getLocalState();

                        ViewGroup eskiTasarimAlani=  (ViewGroup) gorselNesne.getParent();

                        eskiTasarimAlani.removeView(gorselNesne);



                        RelativeLayout hedefTasarimAlani = (RelativeLayout) v;
                        hedefTasarimAlani.addView(gorselNesne,layoutParams);

                        gorselNesne.setVisibility(View.VISIBLE);


                        Log.e("Sonuç","ACTION_DROP");
                        break;

                    default:break;
                }

                return false;
            }
        });
    }
}