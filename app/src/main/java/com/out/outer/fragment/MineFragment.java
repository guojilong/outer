package com.out.outer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.out.outer.AppContext;
import com.out.outer.R;
import com.out.outer.api.OkHttpClientManager;
import com.out.outer.api.Params;
import com.out.outer.api.request.AbstractApiCallbacks;
import com.out.outer.api.request.ApiResponse;
import com.out.outer.api.request.LoginRequest;
import com.out.outer.bean.User;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;


public class MineFragment extends BaseFragment {

    public MineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }


    public void login() {
        Params params = new Params();
        OkHttpClientManager.getAsyn("" + params.toString(), new OkHttpClientManager.ResultCallback<User>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(User user) {

            }


        });

        OkHttpClientManager.postAsyn("", params, new OkHttpClientManager.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });

    }
}
