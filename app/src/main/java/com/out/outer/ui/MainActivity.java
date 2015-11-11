package com.out.outer.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.out.outer.R;
import com.out.outer.fragment.FeedFragment;
import com.out.outer.fragment.FeedNearByFragment;

public class MainActivity extends AppCompatActivity {

    private FeedFragment feedFragment = new FeedFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        FeedNearByFragment feedNearByFragment=new FeedNearByFragment();
        transmit(feedNearByFragment);
    }

    private void transmit(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.add(R.id.container, fragment, fragment.getClass().getSimpleName());
        tx.commit();


    }


}
