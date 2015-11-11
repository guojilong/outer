package com.out.outer.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.joanzapata.android.QuickAdapter;
import com.out.outer.adapter.TagsListAdapter;
import com.out.outer.adapter.UserListAdapter;
import com.out.outer.api.Contacts;
import com.out.outer.bean.Entity;
import com.out.outer.bean.Tag;
import com.out.outer.bean.Tags;
import com.out.outer.bean.User;
import com.out.outer.bean.Users;
import com.out.outer.utils.Toaster;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guojilong on 2015/8/27.
 */
public class FeedNearByFragment extends BaseListFragment<Tags> {

    private QuickAdapter<Tag> adapter;


    @Override
    protected void initView(View mRootView) {
        super.initView(mRootView);
    }

    @Override
    protected void onItemClicked(AdapterView<?> parent, View view, int position, long id) {

        Toaster.shortToast(((Tag) parent.getAdapter().getItem(position)).getName());


    }

    @Override
    protected void addHeaderViews(LayoutInflater inflater) {
        super.addHeaderViews(inflater);

    }

    @Override
    protected QuickAdapter<Tag> getAdapter() {
        if (adapter == null) {
            adapter = new TagsListAdapter(getActivity()).getAdapter();
        }
        return adapter;
    }

    @Override
    protected String getRequestUrl() {
        return Contacts.URL_LOGIN;
    }

    @Override
    protected void onRequestResponse(String tags) {
        String data = getData(tags);
        if (TextUtils.isEmpty(data))
            return;
        Tags tags1 = new Gson().fromJson(data, Tags.class);
        mPage = tags1.getPage();
        mTotalPage = tags1.getTotal_page();
        getAdapter().addAll(tags1.getTags());
        getAdapter().notifyDataSetChanged();


    }


}
