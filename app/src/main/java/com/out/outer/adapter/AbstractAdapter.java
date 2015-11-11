package com.out.outer.adapter;

import android.content.Context;

import com.joanzapata.android.QuickAdapter;

/**
 * Created by guojilong on 2015/8/27.
 */
public abstract class AbstractAdapter<T> {

    public Context context;

    public AbstractAdapter(Context context) {
        this.context = context;
    }


    public abstract QuickAdapter<T> getAdapter();

    public Context getContext() {
        return context;
    }
}
