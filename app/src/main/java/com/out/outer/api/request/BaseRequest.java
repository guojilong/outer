package com.out.outer.api.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by guojilong on 2015/8/26.
 */
public abstract class BaseRequest<T> {

    private AbstractApiCallbacks<T> apiCallbacks;
    private StringRequest stringRequest;
    private Map<String, String> params;
    private String response;
    private String err;
    private RequestQueue queue;


    public BaseRequest(RequestQueue queue, AbstractApiCallbacks<T> apiCallbacks) {
        this.queue = queue;
        this.apiCallbacks = apiCallbacks;
    }

    private String getErrMsg(VolleyError volleyError) {

        return "";
    }

    public void addParams(String key, String value) {
        params.put(key, value);
    }

    public String getParams() {
        if (params == null || params.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.toString();
    }

    public String getResponse() {
        return response;
    }


    public abstract void processInBackground(ApiResponse<T> response);

    public int getMethod() {
        return Request.Method.GET;
    }

    public String getPath() {

        return "";
    }

    public void perform() {
        String path = getPath();
        if (getMethod() == Request.Method.GET) {
            path += getParams();
        }
        stringRequest = new StringRequest(getMethod(), path, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                err = getErrMsg(volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (BaseRequest.this.getMethod() == Method.POST) {
                    return params;
                }
                return super.getParams();
            }
        };
        queue.add(stringRequest);
    }

}
