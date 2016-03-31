package com.nick.moivehomework.Tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/30.
 */
public class HttpUtil {

    public static String getJson(String urlStr) {
        String str = null;
        if (urlStr != null) {
            try {
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setReadTimeout(5000);
                connection.connect();
                if (connection.getResponseCode() == 200) {
                    InputStream in = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1 << 10];
                    int len = 0;
                    while ((len = in.read(buff)) != -1) {
                        bos.write(buff, 0, len);
                    }
                    return bos.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

}
