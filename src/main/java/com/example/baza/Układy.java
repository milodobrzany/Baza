package com.example.baza;

public class Układy {

    int id;
    String nazwa;
    int ilosc;
    float cena;
    String obudowa;
    String produkwany;
    int idProducenta;

    String nazwaProducenta;

    public Układy(int id, String nazwa, int ilosc, float cena, String obudowa, String produkwany, int idProducenta,  String nazwaProducenta) {
        this.id = id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.obudowa = obudowa;
        this.produkwany = produkwany;
        this.idProducenta = idProducenta;
        this.nazwaProducenta = nazwaProducenta;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getObudowa() {
        return obudowa;
    }

    public void setObudowa(String obudowa) {
        this.obudowa = obudowa;
    }

    public String getProdukwany() {
        return produkwany;
    }

    public void setProdukwany(String produkwany) {
        this.produkwany = produkwany;
    }

    public int getIdProducenta() {
        return idProducenta;
    }

    public void setIdProducenta(int idProducenta) {
        this.idProducenta = idProducenta;
    }

    public String getNazwaProducenta() {
        return nazwaProducenta;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }
}
