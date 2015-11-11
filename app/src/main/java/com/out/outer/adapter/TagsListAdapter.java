package com.out.outer.adapter;

import android.content.Context;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.out.outer.R;
import com.out.outer.bean.Tag;

/**
 * Created by guojilong on 2015/8/27.
 */
public class TagsListAdapter extends AbstractAdapter<Tag> {


    public TagsListAdapter(Context context) {
        super(context);
    }

    @Override
    public QuickAdapter<Tag> getAdapter() {
        return new QuickAdapter<Tag>(getContext(), R.layout.item_tag) {
            @Override
            protected void convert(BaseAdapterHelper helper, Tag tag) {
                helper.setText(R.id.tag, tag.getName() + "");

            }
        };
    }


}
