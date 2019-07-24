package com.example.filmlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlist.R;

import java.util.ArrayList;

public class GenreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> genres;
    private GenreAdapter.Callback callback;

    public GenreAdapter(ArrayList<String> genres, GenreAdapter.Callback callback) {
        this.callback = callback;
        this.genres = genres;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_item, parent, false);
        return new GenreAdapter.GenreHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String genre = genres.get(position);
        GenreAdapter.GenreHolder genreHolder = (GenreAdapter.GenreHolder) holder;
        genreHolder.title.setText(genre);
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public static class GenreHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public GenreHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

    public interface Callback {
        void selectGenre(String film);
    }
}
