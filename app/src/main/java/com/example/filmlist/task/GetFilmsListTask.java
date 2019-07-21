package com.example.filmlist.task;

import android.os.AsyncTask;

import com.example.filmlist.model.Film;
import com.example.filmlist.presenter.Presenter;

public class GetFilmsListTask extends AsyncTask<Void, Void, String> {

    private Presenter presenter;

    public GetFilmsListTask(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(Void... voids) {
        presenter.setFilms(getFilms());
        return "success";
    }

    private Film[] getFilms(){

    }
}
