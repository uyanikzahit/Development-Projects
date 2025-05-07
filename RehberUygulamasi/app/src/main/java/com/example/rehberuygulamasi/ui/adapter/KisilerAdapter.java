package com.example.rehberuygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rehberuygulamasi.data.entity.*;
import java.util.List;
import com.example.rehberuygulamasi.databinding.*;
import com.google.android.material.snackbar.Snackbar;

import com.example.rehberuygulamasi.ui.fragment.*;
import com.example.rehberuygulamasi.R;



public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{

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
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.setKisiNesnesi(kisi);

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getKisi_ad()+" silinsin mi? ",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        Log.e("Kişi Sil",String.valueOf(kisi.getKisi_id()));
                    }).show();
        });

        t.satirCard.setOnClickListener(view ->{

            AnasayfaFragmentDirections.KisiDetayGecis gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(view).navigate(gecis);
        });


    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }

}
