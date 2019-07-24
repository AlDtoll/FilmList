package com.example.filmlist.presenter;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.filmlist.FilmFragment;
import com.example.filmlist.ListFragment;
import com.example.filmlist.MainActivity;
import com.example.filmlist.R;
import com.example.filmlist.adapter.FilmAdapter;
import com.example.filmlist.adapter.GenreAdapter;
import com.example.filmlist.common.ConstantEnum;
import com.example.filmlist.model.Film;
import com.example.filmlist.task.GetFilmsListTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Presenter implements Serializable {

    private MainActivity activity;
    private ListFragment listFragment;
    private FilmFragment filmFragment;

    private boolean isActive = true;
    private ArrayList<Film> films = new ArrayList<>();
    private Film selectedFilm = new Film();

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
        listFragment.initRecyclersView();
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void onStart() {
        isActive = true;
        createFragments();
        showFragment(listFragment);
    }

    private void createFragments() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ConstantEnum.PRESENTER.getCode(), this);
        listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        filmFragment = new FilmFragment();
        filmFragment.setArguments(bundle);
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void onStop() {

    }

    public ArrayList<String> getGenres() {
        return new ArrayList<>(Arrays.asList("Pfukeirf"));
    }

    public Film getSelectedFilm() {
        return selectedFilm;
    }

    public void selectFilm(Film film) {
        selectedFilm = film;
        showFragment(filmFragment);
    }
}
