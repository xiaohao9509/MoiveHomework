package com.nick.moivehomework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.Fragments.InfoFragment;
import com.nick.moivehomework.Fragments.MoviesFragment;
import com.nick.moivehomework.Tools.SaveLoved;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.Movies;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements HttpTask.Callback<Movies>, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    public static final String popularity_desc = "popularity.desc";
    private GridView grid;
    public static long tempId = 209112;
    private FrameLayout frame;
    private boolean isButtom = false;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            File file = new File(getFilesDir(), "loved.txt");
            if (!file.exists()){
                file.createNewFile();
            SaveLoved.saveSet(openFileOutput("loved.txt", Context.MODE_PRIVATE));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            SaveLoved.readSet(openFileInput("loved.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        frame = (FrameLayout) findViewById(R.id.main_content);
        MoviesFragment fragment = new MoviesFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_movies, fragment).commit();
//        grid = (GridView) findViewById(R.id.grid);
//        grid.setOnItemClickListener(this);
        if (frame != null && savedInstanceState != null) {
            long id = savedInstanceState.getLong("id");
            InfoFragment infoFragment = InfoFragment.newInstance(id);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, infoFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onResponse(Movies movies) {
        ((ImageAdapter) grid.getAdapter()).addAll(movies.getList());
    }

    @Override
    protected void onStart() {
        super.onStart();
        grid = (GridView) findViewById(R.id.grid);
        grid.setOnItemClickListener(this);
        grid.setOnScrollListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putLong("id", tempId);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        tempId = id;
        if (frame == null) {
            Intent intent = new Intent(this, OtherActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        } else {
            InfoFragment fragment = InfoFragment.newInstance(id);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (isButtom && (scrollState == SCROLL_STATE_IDLE)) {
            new HttpTask<Movies>(Movies.class, this).execute(Urls.getMoviesUrl(++page, popularity_desc, "zh"));
            Toast.makeText(this, "正在加载数据,请稍后~", Toast.LENGTH_SHORT).show();
        } else {
            isButtom = false;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
            isButtom = true;
        } else {
            isButtom = false;
        }
    }
}
