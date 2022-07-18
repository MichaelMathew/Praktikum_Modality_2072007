package com.example.praktikum_modality_2072007.model;

public class Barang {
    private String id;
    private String Nama;
    private String Supplier;

    public Barang(String id, String nama, String supplier) {
        this.id = id;
        Nama = nama;
        Supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }
}

