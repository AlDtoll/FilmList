package com.example.filmlist.model;

import java.util.List;

/**
 * Ответ приходящий от сервера, содержит в себе список языков {@link com.example.filmlist.model.Film}
 */
public class Films {

    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
