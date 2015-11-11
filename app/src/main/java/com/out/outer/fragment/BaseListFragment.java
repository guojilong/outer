package com.out.outer.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.joanzapata.android.QuickAdapter;
import com.out.outer.R;
import com.out.outer.api.OkHttpClientManager;
import com.out.outer.api.Params;
import com.out.outer.bean.Tag;
import com.out.outer.bean.Tags;
import com.out.outer.utils.Toaster;
import com.squareup.okhttp.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;

/**
 * Created by guojilong on 2015/8/26.
 */
public abstract class BaseListFragment<T> extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private int LOAD_TYPE;
    private final int LOAD_REFRESH = 0;
    private final int LOAD_MORE = 1;
    private View mRootView;
    private SwipeRefreshLayout swipeLayout;
    protected ListView mListView;
    private QuickAdapter<T> adapter;
    private boolean isFirstRun = Boolean.TRUE;
    protected int mPage = 1;
    protected int mTotalPage = 0;
    final int endTrigger = 2;
    private boolean isLoadingMore = false;

    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutResource(), container, Boolean.FALSE);
        swipeLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.swiperefreshlayout);
        swipeLayout.setOnRefreshListener(this);
        mListView = (ListView) mRootView.findViewById(R.id.list);
        mListView.setAdapter(getAdapter());
        mListView.setOnScrollListener(scrollListener);
        progressBar = new ProgressBar(getActivity());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClicked(parent, view, position, id);
            }
        });
        IndeterminateProgressDrawable drawable = new IndeterminateProgressDrawable(getActivity());
        progressBar.setIndeterminateDrawable(drawable);
        initView(mRootView);
        initActionBar(mRootView);
        addHeaderViews(inflater);
        addFooterViews(inflater);
        return mRootView;
    }

    protected abstract void onItemClicked(AdapterView<?> parent, View view, int position, long id);

    protected void addFooterViews(LayoutInflater inflater) {
    }


    protected void addHeaderViews(LayoutInflater inflater) {
    }

    protected void initView(View mRootView) {


    }

    protected abstract QuickAdapter<?> getAdapter();


    protected int getLayoutResource() {
        return R.layout.fragment_list;
    }

    @Override
    public void onRefresh() {
        if (isLoadingMore) {
            swipeLayout.setRefreshing(false);
            return;
        }
        LOAD_TYPE = LOAD_REFRESH;
        mPage = 1;
        onLoadData();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isFirstRun) {
            isFirstRun = false;
            onRefresh();
        }
    }

    protected void onLoadData() {
        Params params = new Params();
        params.append("page", mPage + "");
        OkHttpClientManager.getAsyn(getRequestUrl() + params.toString(), new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                resetLoadingAnimation();

                onRequestError(e);
            }

            @Override
            public void onResponse(String t) {
                if (mPage == 1) {
                    getAdapter().clear();
                }
                resetLoadingAnimation();
                onRequestResponse(t);
            }
        });

    }

    private void onRequestError(Exception e) {


    }

    private void resetLoadingAnimation() {
        switch (LOAD_TYPE) {
            case LOAD_REFRESH:
                swipeLayout.setRefreshing(false);
                break;

            case LOAD_MORE:
                onLoadMoreFinish();

                break;
        }


    }

    private void onLoadMoreFinish() {
        isLoadingMore = false;
        mListView.removeFooterView(progressBar);
    }


    private void onLoadMoreStart() {
        isLoadingMore = true;
        mListView.addFooterView(progressBar);

    }

    protected abstract String getRequestUrl();

    protected abstract void onRequestResponse(String t);


    private AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (mListView.getCount() != 0
                    && mListView.getLastVisiblePosition() == (mListView.getCount() - 1)
//                    - endTrigger
                    ) {
                if (swipeLayout.isRefreshing() || isLoadingMore || mPage == mTotalPage) {
                    return;
                }
                // Do what you need to get more content.
                loadMore();
            }

        }
    };


    private void loadMore() {
        LOAD_TYPE = LOAD_MORE;
        mPage++;
        onLoadMoreStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadData();
            }
        }, 300);


    }


    protected String getData(String tags) {
        try {
            JSONObject jsonObject = new JSONObject(tags);

            if (jsonObject.has("code")) {
                if (jsonObject.getInt("code") == 1) {

                    if (jsonObject.has("data")) {
                        String str = jsonObject.getString("data");
                        return str;
                    }
                } else {
                    Toaster.shortToast(jsonObject.getString("error_msg") + "");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


}
