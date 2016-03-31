package com.nick.moivehomework.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class Movies {

    String page;
    String total_results;
    String total_pages;
    List<Movie> list = new ArrayList<Movie>();

    public List<Movie> getList() {
        return list;
    }

    public Movies(String jsonStr) throws JSONException {
        JSONObject object = new JSONObject(jsonStr);
        page = object.optString("page");
        total_results = object.optString("total_results");
        total_pages = object.optString("total_pages");
        JSONArray array = object.optJSONArray("results");
        System.out.println(array.length());
        if (array.length() > 0) {
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.optJSONObject(i);
                if (obj != null) {
                    Movie movie = new Movie(
                            obj.optString("poster_path"),
                            obj.optString("overview"),
                            obj.optString("release_date"),
                            obj.optLong("id"),
                            obj.optString("original_title"),
                            obj.optString("original_language"),
                            obj.optString("title"),
                            obj.optString("backdrop_path"),
                            obj.optString("popularity"),
                            obj.optString("vote_count"),
                            obj.optString("video"),
                            obj.optString("vote_average")
                    );
                    list.add(movie);
                }
            }
        }
    }

    public class Movie {
        private String postr_path;
        private String overview;
        private String release_date;
        private long id;
        private String original_title;
        private String original_language;
        private String title;
        private String backdrop_path;
        private String popularity;
        private String vote_count;
        private String video;
        private String vote_average;

        public Movie(String postr_path, String overview, String release_date, long id, String original_title, String original_language, String title, String backdrop_path, String popularity, String vote_count, String video, String vote_average) {
            this.postr_path = postr_path;
            this.overview = overview;
            this.release_date = release_date;
            this.id = id;
            this.original_title = original_title;
            this.original_language = original_language;
            this.title = title;
            this.backdrop_path = backdrop_path;
            this.popularity = popularity;
            this.vote_count = vote_count;
            this.video = video;
            this.vote_average = vote_average;
        }

        public String getPostr_path() {
            return postr_path;
        }

        public void setPostr_path(String postr_path) {
            this.postr_path = postr_path;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public String getVote_count() {
            return vote_count;
        }

        public void setVote_count(String vote_count) {
            this.vote_count = vote_count;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVote_average() {
            return vote_average;
        }

        public void setVote_average(String vote_average) {
            this.vote_average = vote_average;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "postr_path='" + postr_path + '\'' +
                    ", overview='" + overview + '\'' +
                    ", release_date='" + release_date + '\'' +
                    ", id='" + id + '\'' +
                    ", original_title='" + original_title + '\'' +
                    ", original_language='" + original_language + '\'' +
                    ", title='" + title + '\'' +
                    ", backdrop_path='" + backdrop_path + '\'' +
                    ", popularity='" + popularity + '\'' +
                    ", vote_count='" + vote_count + '\'' +
                    ", video='" + video + '\'' +
                    ", vote_average='" + vote_average + '\'' +
                    '}';
        }
    }


}
