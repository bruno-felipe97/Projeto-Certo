package com.example.ismael.teste;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Bruno on 17/08/17.
 */

public class Games {
    private String id;
    private String name;
    private String release_date;
    private ArrayList <String> platforms;
    private URL trailer;


   public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public ArrayList<String> getPlatforms(){
        return platforms;
    }

    public URL getImage() {
        return trailer;
    }
}

