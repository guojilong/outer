package com.out.outer.utils;

import android.widget.Toast;

import com.out.outer.AppContext;

/**
 * Created by guojilong on 2015/9/1.
 */
public class Toaster {

    public static void shortToast(String s) {

        Toast.makeText(AppContext.getInstance().getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public static void shortToast(int id) {

        Toast.makeText(AppContext.getInstance().getApplicationContext(), AppContext.getInstance().getString(id), Toast.LENGTH_SHORT).show();
    }

    public static void longToast(String s) {

        Toast.makeText(AppContext.getInstance().getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(int id) {

        Toast.makeText(AppContext.getInstance().getApplicationContext(), AppContext.getInstance().getString(id), Toast.LENGTH_SHORT).show();
    }
}
