package com.nick.moivehomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.Fragments.MoviesFragment;
import com.nick.moivehomework.entities.Movies;

public class MainActivity extends AppCompatActivity implements HttpTask.Callback<Movies>, AdapterView.OnItemClickListener {
    public static final String popularity_desc = "popularity.desc";
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesFragment fragment = new MoviesFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_movies, fragment).commit();
//        grid = (GridView) findViewById(R.id.grid);
//        grid.setOnItemClickListener(this);
    }

    @Override
    public void onResponse(Movies movies) {
        System.out.println("!!");
        System.out.println(movies.getList().toString());
        System.out.println(movies.getList().size());
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
