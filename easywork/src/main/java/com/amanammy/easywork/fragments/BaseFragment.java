package com.amanammy.easywork.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.amanammy.easywork.BaseActivity;

/**
 * Created by amandeep on 13/10/15.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        }
    }


    /**
     * Replace current view to given fragment from fragment
     *
     * @param fragment
     */
    protected void replaceFragment(Fragment fragment) {

        mActivity.replaceFragment(fragment, 10);
    }


    protected void replaceFragment(Fragment fragment, Boolean storeInStack) {

        mActivity.replaceFragment(fragment, 10, storeInStack);
    }

    protected void replaceFragment(Fragment fragment, boolean storeInStack, boolean isAdd) {

        mActivity.replaceFragment(fragment, 10, storeInStack, isAdd);
    }

    /**
     * initialize all views of activity under this method
     */
    protected abstract void initViews(View view);




    @Override
    public void onStop() {
        super.onStop();
    }
}
