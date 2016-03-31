package com.nick.moivehomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.entities.Movies;

public class MainActivity extends AppCompatActivity implements HttpTask.Callback<Movies> {
    public static final String popularity_desc ="popularity.desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_movies,new MoviesFragment()).commit();
    }

    @Override
    public void onResponse(Movies movies) {
        System.out.println("!!");
        System.out.println(movies.getList().toString());
        System.out.println(movies.getList().size());
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}
