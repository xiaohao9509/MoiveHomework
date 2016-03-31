package com.nick.moivehomework.AsyncTask;

import android.os.AsyncTask;

import com.nick.moivehomework.entities.ErrorResponse;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/30.
 */
public class HttpTask<T extends Object> extends AsyncTask<String, Void, Object> {
    private Class<T> clazz;
    private Callback<T> callback;

    public HttpTask(Class<T> clazz, Callback<T> callback) {
        this.clazz = clazz;
        this.callback = callback;
    }

    @Override
    protected Object doInBackground(String... params) {
        String urlStr = null;
        if (params != null) {
            urlStr = params[0];
        }
        URL url = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buff = new byte[1 << 10];
                int len = 0;
                while ((len = in.read(buff)) != -1) {
                    bos.write(buff, 0, len);
                }
                Constructor<T> constructor = clazz.getConstructor(String.class);
                return constructor.newInstance(bos.toString("UTF-8"));
            } else {
                return new ErrorResponse("网络错误:" + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }

    }

    @Override
    protected void onPostExecute(Object o) {
        if (o != null) {
            callback.onResponse((T) o);
        } else {
            callback.onFailure(((ErrorResponse) o).getError());
        }
    }

    public interface Callback<T extends Object> {
        void onResponse(T t);

        void onFailure(String error);
    }
}
