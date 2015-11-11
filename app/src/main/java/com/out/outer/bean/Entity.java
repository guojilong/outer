package com.out.outer.bean;

import java.io.Serializable;

/**
 * Created by guojilong on 2015/8/27.
 */
public class Entity<T> extends Base {
    private String code = "";
    private String err_message = "";

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErr_message() {
        return err_message;

    }

    public void setErr_message(String err_message) {
        this.err_message = err_message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
