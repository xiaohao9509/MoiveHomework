package com.nick.moivehomework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nick.moivehomework.Tools.Urls;
import com.nick.moivehomework.entities.Movies;
import com.squareup.picasso.Picasso;

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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        }
        Movies.Movie movie = list.get(position);
        String imgUrl = String.format(Urls.getImageUrl("342",movie.getPostr_path()));
        System.out.println(movie.getPostr_path()+"+");
        System.out.println(convertView.findViewById(R.id.item_image).getWidth());
        Picasso.with(context).load(imgUrl).placeholder(R.mipmap.loading).into((MyImageView) convertView.findViewById(R.id.item_image));
        return convertView;
    }
}
