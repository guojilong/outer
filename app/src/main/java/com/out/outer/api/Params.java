package com.out.outer.api;

import java.util.HashMap;

/**
 * Created by guojilong on 2015/8/27.
 */
public class Params extends HashMap<String, String> {


    public Params() {

    }

    public void append(String key, String value) {
        this.put(key, value);
    }

    public String toString() {
        if (this.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Entry<String, String> entry : this.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.toString();

    }
}
