package com.nick.moivehomework.Tools;

/**
 * Created by Administrator on 2016/3/30.
 */
public class Urls {
    private final static String BASE_JSON_URL = "http://api.themoviedb.org/3/discover/movie?page=%d&sort_by=%s&language=%s&api_key=4a27a998bd62643d3ed78df0c5427bd2";
    private final static String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w%s%s";
    private final static String BASE_INFO_URL = "https://api.themoviedb.org/3/movie/%d?api_key=4a27a998bd62643d3ed78df0c5427bd2&language=%s";
    public static String getMoviesUrl(int page,String sort,String language){
        return String.format(BASE_JSON_URL,page,sort,language);
    }

    public static String getImageUrl(String width,String imageUrl){
        return String.format(BASE_IMAGE_URL,width,imageUrl);
    }

    public static String getInfoUrl(int id,String language){
        return String.format(BASE_INFO_URL,id,language);
    }

}
