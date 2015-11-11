package com.out.outer.api.request;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.out.outer.bean.User;

/**
 * Created by guojilong on 2015/8/26.
 */
public class LoginRequest extends BaseRequest<User> {
    public LoginRequest(RequestQueue queue,AbstractApiCallbacks<User> apiCallbacks) {
        super(queue,apiCallbacks);
    }

    @Override
    public void addParams(String key, String value) {
        super.addParams(key, value);
    }

    @Override
    public int getMethod() {
        return Request.Method.POST;
    }

    @Override
    public String getPath() {
        return "";
    }

    @Override
    public void processInBackground(ApiResponse<User> response) {
        Gson gson = new Gson();
        User user = gson.fromJson(getResponse(), User.class);
        response.setSuccessObject(user);
    }
}
