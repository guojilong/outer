package com.out.outer.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.joanzapata.android.QuickAdapter;
import com.out.outer.adapter.UserListAdapter;
import com.out.outer.api.Contacts;
import com.out.outer.bean.User;
import com.out.outer.bean.Users;

/**
 * Created by guojilong on 2015/8/27.
 */
public class FeedFollowFragment extends BaseListFragment<Users> {


    @Override
    protected void initView(View mRootView) {
        super.initView(mRootView);
    }

    @Override
    protected void onItemClicked(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void addHeaderViews(LayoutInflater inflater) {
        super.addHeaderViews(inflater);

    }

    @Override
    protected QuickAdapter<User> getAdapter() {

        return new UserListAdapter(getActivity()).getAdapter();
    }

    @Override
    protected String getRequestUrl() {
        return Contacts.URL_LOGIN;
    }

    @Override
    protected void onRequestResponse(String users) {

    }
}
