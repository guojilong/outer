package com.out.outer.api.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by guojilong on 2015/8/26.
 */
public class GsonRequest<T> extends JsonRequest<JsonObject> {

    public GsonRequest(int method, String url, String requestBody, Response.Listener<JsonObject> listener, Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }

    @Override
    protected Response<JsonObject> parseNetworkResponse(NetworkResponse response) {
        return null;
    }
}
