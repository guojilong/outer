package com.out.outer.api.request;

import com.out.outer.bean.User;

/**
 * Created by guojilong on 2015/8/26.
 */
public class ApiResponse<T> {

    private T mt;

    public void setSuccessObject(T t) {
        this.mt = t;
    }

}
