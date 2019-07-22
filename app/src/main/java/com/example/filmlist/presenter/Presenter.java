package com.example.filmlist.presenter;

import android.app.AlertDialog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlist.MainActivity;
import com.example.filmlist.R;
import com.example.filmlist.adapter.FilmAdapter;
import com.example.filmlist.adapter.GenreAdapter;
import com.example.filmlist.model.Film;
import com.example.filmlist.task.GetFilmsListTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Presenter {

    private MainActivity activity;

    private boolean isActive = true;
    private ArrayList<Film> films = new ArrayList<>();

    public Presenter(MainActivity activity) {
        attachView(activity);
        new GetFilmsListTask(this).execute();
    }

    private void attachView(MainActivity activity) {
        this.activity = activity;
    }

    public void showError(String errorText) {
        if (isActive) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder
                    .setTitle("Ошибка")
                    .setMessage(errorText)
                    .create();
            builder.show();
        }
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
        initRecyclersView();
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void onStart() {
        isActive = true;
    }

    private FilmAdapter.Callback filmCallback = new FilmAdapter.Callback() {
        @Override
        public void selectFilm(Film film) {

        }
    };

    private GenreAdapter.Callback genreCallback = new GenreAdapter.Callback() {
        @Override
        public void selectGenre(String film) {

        }
    };

    private void initRecyclersView() {
        RecyclerView filmList = activity.findViewById(R.id.filmList);
        FilmAdapter filmAdapter = new FilmAdapter(films, filmCallback);
        filmList.setAdapter(filmAdapter);

        RecyclerView genreList = activity.findViewById(R.id.genreList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        genreList.setLayoutManager(linearLayoutManager);
        GenreAdapter genreAdapter = new GenreAdapter(getGenres(), genreCallback);
        genreList.setAdapter(genreAdapter);
    }

    public void onStop() {

    }

    private ArrayList<String> getGenres() {
        return new ArrayList<>(Arrays.asList(films.get(0).getGenres()));
    }
}
