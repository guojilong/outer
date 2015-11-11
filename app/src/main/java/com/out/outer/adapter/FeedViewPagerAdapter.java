package com.out.outer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.out.outer.fragment.FeedFollowFragment;
import com.out.outer.fragment.FeedHotFragment;
import com.out.outer.fragment.FeedNearByFragment;

import java.util.List;

/**
 * Created by guojilong on 2015/8/28.
 */
public class FeedViewPagerAdapter extends FragmentPagerAdapter {
    public FeedViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FeedViewPagerAdapter(FragmentManager fm, List<Fragment> fragmengs) {
        super(fm);


    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FeedFollowFragment();

            case 1:
                return new FeedHotFragment();
            case 2:
                return new FeedNearByFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
