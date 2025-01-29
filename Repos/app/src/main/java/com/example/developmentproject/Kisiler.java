package com.example.developmentproject;

import java.io.Serializable;

public class Kisiler implements Serializable {
    private int tcno;
    private  String isim;
    private  int boy;

    public int getTcno() {
        return tcno;
    }

    public void setTcno(int tcno) {
        this.tcno = tcno;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public Kisiler() {
    }

    public Kisiler(int tcno, String isim, int boy) {
        this.tcno = tcno;
        this.isim = isim;
        this.boy = boy;
    }
}
