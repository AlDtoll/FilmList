package com.example.filmlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlist.adapter.FilmAdapter;
import com.example.filmlist.adapter.GenreAdapter;
import com.example.filmlist.common.ConstantEnum;
import com.example.filmlist.model.Film;
import com.example.filmlist.presenter.Presenter;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private Presenter presenter;
    private View fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = (Presenter) getArguments().getSerializable(ConstantEnum.PRESENTER.getCode());
        fragment = inflater.inflate(R.layout.fragment_list, container, false);
//        initRecyclersView();
        return fragment;
    }

    private FilmAdapter.Callback filmCallback = new FilmAdapter.Callback() {
        @Override
        public void selectFilm(Film film) {
            presenter.selectFilm(film);
        }
    };

    private GenreAdapter.Callback genreCallback = new GenreAdapter.Callback() {
        @Override
        public void selectGenre(String film) {

        }
    };

    public void initRecyclersView() {
        RecyclerView genreList = fragment.findViewById(R.id.genreList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        genreList.setLayoutManager(linearLayoutManager);
        GenreAdapter genreAdapter = new GenreAdapter(presenter.getGenres(), genreCallback);
        genreList.setAdapter(genreAdapter);

        RecyclerView filmList = fragment.findViewById(R.id.filmList);
        FilmAdapter filmAdapter = new FilmAdapter(presenter.getFilms(), filmCallback, getActivity());
        filmList.setAdapter(filmAdapter);

    }
}
