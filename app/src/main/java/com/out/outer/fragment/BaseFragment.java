package com.out.outer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.out.outer.AppContext;
import com.out.outer.R;

/**
 * Created by guojilong on 2015/8/26.
 */
public class BaseFragment extends android.support.v4.app.Fragment {

    private TextView mTitleView;
    private TextView mActionbarRight;
    private TextView mActionbarLeft;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean useBackActionbar() {
        return true;
    }

    protected void initActionBar(View view) {
        if (view != null) {
            mActionbarLeft = (TextView) view.findViewById(R.id.actionbar_back);
            mTitleView = (TextView) view.findViewById(R.id.actionbar_text);
            mActionbarRight = (TextView) view.findViewById(R.id.actionbar_right);
            if (useBackActionbar() && mActionbarLeft != null) {
                mActionbarLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getActivity() != null) {
                            hideKeyboard();
                            getActivity().finish();
                        }
                    }
                });
            }
        }
    }

    /**
     * @return
     */
    public TextView getActionbarRightView() {
        return mActionbarRight;
    }

    public TextView getActionbarLeftView() {
        return mActionbarLeft;
    }

    public void setText(String text) {
        if (mTitleView != null) {
            mTitleView.setText(text);
        }
    }

    public void setText(int text) {
        if (mTitleView != null) {
            mTitleView.setText(text);
        }
    }

    public void showKeyboard() {
        ((InputMethodManager) AppContext.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideKeyboard() {
        if (getView() != null) {
            ((InputMethodManager) AppContext.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getView()
                    .getWindowToken(), 0);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
