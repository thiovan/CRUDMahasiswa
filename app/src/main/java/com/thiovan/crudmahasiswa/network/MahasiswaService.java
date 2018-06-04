package com.thiovan.crudmahasiswa.network;

import com.thiovan.crudmahasiswa.models.Mahasiswa;
import com.thiovan.crudmahasiswa.models.MahasiswaResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MahasiswaService {
    @GET("mahasiswa")
    Call<MahasiswaResult> getMahasiswas();

    @GET("mahasiswa/{id}")
    Call<MahasiswaResult> getMahasiswa(@Path("id") int id);

    @POST("mahasiswa")
    Call<String> setMahasiswa(@Body Mahasiswa mahasiswa);

    @DELETE("mahasiswa/{id}")
    Call<String> hapusMahasiwa(@Path("id") int id);
}
