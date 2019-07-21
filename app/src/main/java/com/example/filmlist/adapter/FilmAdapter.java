package com.example.filmlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlist.R;
import com.example.filmlist.model.Film;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Film> films;
    private Callback callback;

    public FilmAdapter(ArrayList<Film> films, Callback callback) {
        this.callback = callback;
        this.films = films;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Film film = films.get(position);
        FilmHolder filmHolder = (FilmHolder) holder;
        filmHolder.title.setText(film.getLocalized_name());
//        filmHolder.poster.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class FilmHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView poster;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.poster);
        }
    }

    public interface Callback {
        void selectFilm(Film film);
    }
}
