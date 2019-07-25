package com.example.filmlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.filmlist.common.ConstantEnum;
import com.example.filmlist.model.Film;
import com.example.filmlist.presenter.Presenter;
import com.squareup.picasso.Picasso;

public class FilmFragment extends Fragment {

    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = (Presenter) getArguments().getSerializable(ConstantEnum.PRESENTER.getCode());
        View fragment = inflater.inflate(R.layout.fragment_film, container, false);
        Film selectedFilm = presenter.getSelectedFilm();
        ImageView poster = fragment.findViewById(R.id.poster);
        Picasso.with(getContext())
                .load(selectedFilm.getImage_url())
                .placeholder(R.drawable.placeholder)
                .into(poster);
        TextView title = fragment.findViewById(R.id.title);
        title.setText(selectedFilm.getLocalized_name());
        TextView description = fragment.findViewById(R.id.description);
        description.setText(selectedFilm.getDescription());
        TextView rating = fragment.findViewById(R.id.rating);
        rating.setText(String.valueOf(selectedFilm.getRating()));
        TextView year = fragment.findViewById(R.id.year);
        year.setText(String.valueOf(selectedFilm.getYear()));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().setTitle(selectedFilm.getLocalized_name());

        return fragment;
    }
}
