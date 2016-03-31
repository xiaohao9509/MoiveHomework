package com.nick.moivehomework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nick.moivehomework.entities.Movies;

import java.util.List;

/**
 * Created by Administrator on 2016/3/31.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private List<Movies.Movie> list;

    public ImageAdapter(Context context, List<Movies.Movie> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){

        }
        return null;
    }

    class ViewHolder{
        ImageView imageView;
    }
}
