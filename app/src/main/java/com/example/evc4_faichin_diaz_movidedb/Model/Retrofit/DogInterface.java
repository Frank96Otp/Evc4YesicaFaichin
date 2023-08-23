package com.example.evc4_faichin_diaz_movidedb.Model.Retrofit;

import com.example.evc4_faichin_diaz_movidedb.Model.Response.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogInterface {

    @GET("breed/hound/images")
    Call<DogResponse> getListDogs();
}
