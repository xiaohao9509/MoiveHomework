package com.nick.moivehomework.Tools;

import com.nick.moivehomework.entities.MovieInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/**
 * Created by Administrator on 2016/4/4.
 */
public class SaveLoved {

    public static HashSet<MovieInfo> set = new HashSet<>();

    public static boolean addLoved(MovieInfo movieInfo){
        return set.add(movieInfo);
    }

    public static boolean removeLoved(MovieInfo movieInfo){
        return set.remove(movieInfo);
    }

    public static void saveSet(FileOutputStream fos) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(set);
    }

    public static void readSet(FileInputStream fis) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(fis);
        set.addAll((HashSet<MovieInfo>)ois.readObject());
    }

    public static HashSet<MovieInfo> getSet(){
        return set;
    }


}
