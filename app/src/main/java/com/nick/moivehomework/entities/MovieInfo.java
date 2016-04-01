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
        imdb_id = object.optString("imdb_id");
        original_language = object.optString("original_language");
        original_title = object.optString("original_title");
        overview = object.optString("overview");
        popularity = object.optString("popularity");
        poster_path = object.optString("poster_path");
        release_date = object.optString("release_date");
        status = object.optString("status");
        title = object.optString("title");
        video = object.optBoolean("video");
        vote_average = object.optString("vote_average");
        vote_count = object.optString("vote_count");
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }
}
