package com.out.outer.bean;

import java.util.List;

/**
 * Created by guojilong on 2015/8/27.
 */
public class Users extends Entity {
    private int mPage;
    private int mTotal_page;
    private List<User> users;

    public int getmPage() {
        return mPage;
    }

    public void setmPage(int mPage) {
        this.mPage = mPage;
    }

    public int getmTotal_page() {
        return mTotal_page;
    }

    public void setmTotal_page(int mTotal_page) {
        this.mTotal_page = mTotal_page;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
