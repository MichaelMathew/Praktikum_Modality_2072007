package com.example.praktikum_modality_2072007.model;

public class Supplier {
    private String idSupplier;
    private String NamaSupplier;
    private String Alamat;

    public Supplier(String idSupplier, String namaSupplier, String alamat) {
        this.idSupplier = idSupplier;
        NamaSupplier = namaSupplier;
        Alamat = alamat;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaSupplier() {
        return NamaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        NamaSupplier = namaSupplier;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }
}

