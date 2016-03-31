package com.nick.moivehomework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.Movies;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements HttpTask.Callback<Movies> {

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
        new HttpTask<Movies>(Movies.class,this).execute(Urls.getMoviesUrl(1,MainActivity.popularity_desc,"zh"));
        return view;
    }


    @Override
    public void onResponse(Movies movies) {
        list.addAll(movies.getList());

        System.out.println("ok");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String error) {

    }
}
