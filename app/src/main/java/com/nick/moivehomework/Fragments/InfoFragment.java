package com.nick.moivehomework.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nick.moivehomework.AsyncTask.HttpTask;
import com.nick.moivehomework.R;
import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.MovieInfo;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements HttpTask.Callback<MovieInfo> {


    private Button button;
    private TextView average;
    private TextView name;
    private TextView overview;
    private TextView year;
    private ImageView image;

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
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        button = (Button) view.findViewById(R.id.detail_add);
        average = (TextView) view.findViewById(R.id.detail_average);
        name = (TextView) view.findViewById(R.id.detail_name);
        overview = (TextView) view.findViewById(R.id.detail_overview);
        year = (TextView) view.findViewById(R.id.detail_year);
        image = (ImageView) view.findViewById(R.id.detail_image);


        return view;
    }

    @Override
    public void onResponse(MovieInfo movieInfo) {
        average.setText(movieInfo.getVote_average() + "/10");
        name.setText(movieInfo.getTitle());
        overview.setText(movieInfo.getOverview());
        year.setText(movieInfo.getRelease_date());
        String imgUrl = Urls.getImageUrl("500",movieInfo.getPoster_path());
        System.out.println(imgUrl);
        Picasso.with(getContext()).load(imgUrl).placeholder(R.mipmap.loading1).into(image);

    }

    @Override
    public void onFailure(String error) {

    }
}
