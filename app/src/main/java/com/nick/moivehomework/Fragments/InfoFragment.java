package com.nick.moivehomework.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.R;
import com.nick.moivehomework.Tools.SaveLoved;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.MovieInfo;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements HttpTask.Callback<MovieInfo>, CompoundButton.OnCheckedChangeListener {


    private Button button;
    private TextView average;
    private TextView name;
    private TextView overview;
    private TextView year;
    private ImageView image;
    private RatingBar rating;
    private TextView count;
    private TextView language;
    private CheckBox loved;
    private HashSet<MovieInfo> movies = new HashSet<>();
    private MovieInfo movieInfo;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(long id) {

        Bundle args = new Bundle();
        args.putLong("id", id);
        InfoFragment fragment = new InfoFragment();
        String url = Urls.getInfoUrl((int) id, "zh");
        new HttpTask<MovieInfo>(MovieInfo.class, fragment).execute(url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        movies.clear();
        movies.addAll(SaveLoved.getSet());
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        button = (Button) view.findViewById(R.id.detail_add);
        average = (TextView) view.findViewById(R.id.detail_average);
        name = (TextView) view.findViewById(R.id.detail_name);
        overview = (TextView) view.findViewById(R.id.detail_overview);
        year = (TextView) view.findViewById(R.id.detail_year);
        image = (ImageView) view.findViewById(R.id.detail_image);
        rating = ((RatingBar) view.findViewById(R.id.detail_rating));
        count = ((TextView) view.findViewById(R.id.detail_count));
        language = ((TextView) view.findViewById(R.id.detail_language));
        loved = ((CheckBox) view.findViewById(R.id.detail_add));
        loved.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onResponse(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
        String vote_average = movieInfo.getVote_average();
        rating.setRating(Float.parseFloat(vote_average)/2.0f);
        average.setText(vote_average);
        name.setText(movieInfo.getTitle());
        overview.setText(movieInfo.getOverview());
        year.setText(movieInfo.getRelease_date());
        count.setText(movieInfo.getVote_count());
        String lang = movieInfo.getOriginal_language();
        if (movies.contains(movieInfo)){
            loved.setChecked(true);
        }
        switch (lang){
            case "en":
                language.setText("英语");
                break;
            case "zh":
                language.setText("中文");
                break;
        }
        String imgUrl = Urls.getImageUrl("500",movieInfo.getPoster_path());
        Picasso.with(getContext()).load(imgUrl).placeholder(R.mipmap.loading1).into(image);

    }

    @Override
    public void onFailure(String error) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            SaveLoved.addLoved(movieInfo);
        }else {
            SaveLoved.removeLoved(movieInfo);
        }
        try {
            SaveLoved.saveSet(getActivity().openFileOutput("loved.txt", Context.MODE_PRIVATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
