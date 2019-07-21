package com.example.filmlist.presenter;

import com.example.filmlist.MainActivity;
import com.example.filmlist.task.GetFilmsListTask;

public class Presenter {

    private MainActivity activity;

    public Presenter(MainActivity activity) {
        attachView(activity);
        new GetFilmsListTask(this).execute();
    }

    private void attachView(MainActivity activity) {
        this.activity = activity;
    }

}
