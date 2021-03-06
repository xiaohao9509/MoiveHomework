package com.nick.moivehomework.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.ImageAdapter;
import com.nick.moivehomework.MainActivity;
import com.nick.moivehomework.R;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.Movies;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class  MoviesFragment extends Fragment implements HttpTask.Callback<Movies>, AdapterView.OnItemClickListener {

    List<Movies.Movie> list = new ArrayList<>();
    private ImageAdapter adapter;


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.grid);

        adapter = new ImageAdapter(getActivity(), list);
        gridView.setAdapter(adapter);
        new HttpTask<Movies>(Movies.class, this).execute(Urls.getMoviesUrl(1, MainActivity.popularity_desc, "zh"));
       // gridView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onResponse(Movies movies) {
        list.addAll(movies.getList());
        adapter.notifyDataSetChanged();
        long id = movies.getList().get(0).getId();
        if (MainActivity.tempId != id) {
            MainActivity.tempId = id;
        }
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(getActivity(), "错误:" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
