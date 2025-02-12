package com.example.notlaruygulamasi_design;

import java.io.Serializable;

public class Notlar implements Serializable {
    private  int not_id;
    private String ders_adi;
    private int not_1;;
    private int not_2;

    public Notlar() {
    }

    public Notlar(int not_id, String ders_adi, int not_1, int not_2) {
        this.not_id = not_id;
        this.ders_adi = ders_adi;
        this.not_1 = not_1;
        this.not_2 = not_2;
    }

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public int getNot_1() {
        return not_1;
    }

    public void setNot_1(int not_1) {
        this.not_1 = not_1;
    }

    public int getNot_2() {
        return not_2;
    }

    public void setNot_2(int not_2) {
        this.not_2 = not_2;
    }
}
