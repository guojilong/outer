package com.out.outer.adapter;

import android.content.Context;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.out.outer.R;
import com.out.outer.bean.Tag;
import com.out.outer.bean.User;

/**
 * Created by guojilong on 2015/8/27.
 */
public class UserListAdapter extends AbstractAdapter<User> {


    public UserListAdapter(Context context) {
        super(context);
    }

    @Override
    public QuickAdapter<User> getAdapter() {
        return new QuickAdapter<User>(context, R.layout.layout_feed_tabs) {
            @Override
            protected void convert(BaseAdapterHelper helper, User user) {

            }
        };
    }


}
