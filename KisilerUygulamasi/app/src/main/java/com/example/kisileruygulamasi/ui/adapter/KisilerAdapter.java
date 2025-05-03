package com.example.kisileruygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.ui.*;

import com.example.kisileruygulamasi.databinding.CardTasarimBinding;
import com.example.kisileruygulamasi.r;
import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;


public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List<Kisiler> kisilerListesi;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListesi) {
        this.mContext = mContext;
        this.kisilerListesi = kisilerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu( CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }


    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewKisiBilgi.setText(kisi.getKisi_ad()+" - "+kisi.getKisi_tel());
        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getKisi_ad()+" silinsin mi? ",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        Log.e("Kişi Sil",String.valueOf(kisi.getKisi_id()));
                    }).show();
        });

        t.satirCard.setOnClickListener(view ->{
            FragmentAnaSayfaBinding. gecis = FragmentAnaSayfaBinding
        });

    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }
}
