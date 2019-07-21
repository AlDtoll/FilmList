package com.example.filmlist.task;

import android.os.AsyncTask;

import com.example.filmlist.model.Film;
import com.example.filmlist.model.Films;
import com.example.filmlist.network.FilmsApi;
import com.example.filmlist.network.MyRetrofit;
import com.example.filmlist.presenter.Presenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFilmsListTask extends AsyncTask<Void, Void, String> {

    private Presenter presenter;

    public GetFilmsListTask(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(Void... voids) {
        FilmsApi filmsApi = MyRetrofit.filmsApi;
        Call<Films> films = filmsApi.getFilms();
        films.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                analyzeResponse(response);
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                presenter.showError("Неудалось получить список фильмов");
            }
        });
        return "success";
    }

    private void analyzeResponse(Response<Films> response) {
        if (response.isSuccessful()) {
            ArrayList<Film> films = (ArrayList) response.body().getFilms();
            presenter.setFilms(films);
        }
    }
}
