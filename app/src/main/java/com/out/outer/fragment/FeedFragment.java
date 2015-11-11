package com.out.outer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.out.outer.R;
import com.out.outer.adapter.FeedViewPagerAdapter;

import java.util.List;


public class FeedFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ViewPager viewPager;
    private FeedViewPagerAdapter fragmentPagerAdapter;
    private LinearLayout feed_follow, feed_hot, feed_nearby;
    private TextView tv_feed_follow, tv_feed_hot, tv_feed_nearby;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_feed, container, false);
        initView(view);
        setOnclickListener();
        return view;
    }

    private void setOnclickListener() {
        feed_follow.setOnClickListener(this);
        feed_hot.setOnClickListener(this);
        feed_nearby.setOnClickListener(this);


    }

    private void initView(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        fragmentPagerAdapter = new FeedViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        feed_follow = (LinearLayout) view.findViewById(R.id.feed_follow);
        feed_hot = (LinearLayout) view.findViewById(R.id.feed_hots);
        feed_nearby = (LinearLayout) view.findViewById(R.id.feed_nearby);


    }


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.feed_follow:
                viewPager.setCurrentItem(0);
                break;
            case R.id.feed_hots:
                viewPager.setCurrentItem(1);
                break;
            case R.id.feed_nearby:
                viewPager.setCurrentItem(2);
                break;
        }

    }
}
