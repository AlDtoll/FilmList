package com.example.filmlist.network;

import com.example.filmlist.model.Films;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmsApi {

    @GET("films.json")
    Call<Films> getFilms();
}
