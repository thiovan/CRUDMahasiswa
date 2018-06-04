package com.thiovan.crudmahasiswa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MahasiswaResult {
    @SerializedName("mahasiswas")
    @Expose
    public List<Mahasiswa> mahasiswas = null;

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }
}
