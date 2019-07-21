package com.example.filmlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.filmlist.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
