package com.example.jsonparseislemi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String jsonVeri = "{\"bayraklar\":[{\"bayrak_id\":\"1\",\"bayrak_ad\":\\u00fcrkiye\",\"bayrak_resim\":\"turkiye\"},{\"bayrak_id\":\"2\",\"bayrak_ad\":\\u00fcrkiye\",\"bayrak_resim\":\"turkiye\"}],\"success\":1}";
        try {
            JSONObject jsonObject = new JSONObject(jsonVeri);

            JSONArray bayraklarListe = jsonObject.getJSONArray("bayraklar");
            for(int i =0; i<bayraklarListe.length(); i++){
                JSONObject b = bayraklarListe.getJSONObject(i);

                int bayrak_id = b.getInt("bayrak_id");
                String bayrak_ad = b.getString("bayrak_ad");
                String bayrak_resim = b.getString("bayrak_resim");

                Log.e("**************","*********");
                Log.e("bayrak_id",String.valueOf(bayrak_id));
                Log.e("bayrak_ad",bayrak_ad);
                Log.e("bayrak_resim",bayrak_resim);
                Log.e("**************","*********");


            }




        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}