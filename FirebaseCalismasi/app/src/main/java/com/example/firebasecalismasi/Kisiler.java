package com.example.firebasecalismasi;

public class Kisiler {
    private String kisi_key;
    private String kisi_ad;
    private  int kisi_yas;

    public Kisiler() {
    }

    public Kisiler(String kisi_key, String kisi_ad, int kisi_yas) {
        this.kisi_key = kisi_key;
        this.kisi_ad = kisi_ad;
        this.kisi_yas = kisi_yas;
    }

    public String getKisi_key() {
        return kisi_key;
    }

    public void setKisi_key(String kisi_key) {
        this.kisi_key = kisi_key;
    }

    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public int getKisi_yas() {
        return kisi_yas;
    }

    public void setKisi_yas(int kisi_yas) {
        this.kisi_yas = kisi_yas;
    }
}
