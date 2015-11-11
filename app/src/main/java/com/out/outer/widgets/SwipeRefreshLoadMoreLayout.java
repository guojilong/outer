package com.out.outer.widgets;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by guojilong on 2015/8/28.
 */
public class SwipeRefreshLoadMoreLayout extends SwipeRefreshLayout {
    public SwipeRefreshLoadMoreLayout(Context context) {
        super(context);
    }

    public SwipeRefreshLoadMoreLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
