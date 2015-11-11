package com.out.outer;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by guojilong on 2015/8/26.
 */
public class AppContext extends Application {

    public static AppContext instance;
    private RequestQueue mRequestQueue;

    public static AppContext getInstance() {

        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getInstance());
        }
        return mRequestQueue;
    }


}
