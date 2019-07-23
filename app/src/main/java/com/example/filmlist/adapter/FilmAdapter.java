package com.example.filmlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlist.R;
import com.example.filmlist.model.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Film> films;
    private Callback callback;
    private Context context;

    public FilmAdapter(ArrayList<Film> films, Callback callback, Context context) {
        this.callback = callback;
        this.films = films;
        this.context = context;
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
        final Film film = films.get(position);
        FilmHolder filmHolder = (FilmHolder) holder;
        filmHolder.title.setText(film.getLocalized_name());
        holder.itemView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.selectFilm(film);
            }
        }));
        Picasso.with(context)
                .load(film.getImage_url())
                .into(filmHolder.poster);
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
