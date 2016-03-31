package com.nick.moivehomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.Movies;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements HttpTask.Callback<Movies> {
    public static final String popularity_desc ="popularity.desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load("http://www.baidu.com/img/bd_logo.png").into(imageView);
        String url = Urls.getMoviesUrl(1,popularity_desc,"zh");
        System.out.println(url);
        new HttpTask<Movies>(Movies.class,this).execute(url);
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
