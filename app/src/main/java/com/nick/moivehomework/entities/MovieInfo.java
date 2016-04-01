package com.nick.moivehomework.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/4/1.
 */
public class MovieInfo {
    private String backdrop_path;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private String popularity;
    private String poster_path;
    private String release_date;
    private String status;
    private String title;
    private boolean video;
    private String vote_average;
    private String vote_count;

    public MovieInfo(String jsonStr) throws JSONException {
        JSONObject object = new JSONObject(jsonStr);
        backdrop_path = object.optString("backdrop_path");
        id = object.optInt("id");
        imdb_id = object.optString("backdrop_path");
        original_language = object.optString("backdrop_path");
        original_title = object.optString("backdrop_path");
        overview = object.optString("backdrop_path");
        popularity = object.optString("backdrop_path");
        poster_path = object.optString("backdrop_path");
        release_date = object.optString("backdrop_path");
        status = object.optString("backdrop_path");
        title = object.optString("backdrop_path");
        video = object.optBoolean("backdrop_path");
        vote_average = object.optString("vote_average");
        vote_count = object.optString("vote_count");
    }
}
