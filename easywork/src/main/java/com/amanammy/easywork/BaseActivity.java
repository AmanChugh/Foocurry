package com.amanammy.easywork;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout activityContent = null;
    private Toolbar mToolbar = null;
    private TextView mTitleText;
    private int mLayoutId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitleText = (TextView) findViewById(R.id.tv_toolbar);
        activityContent = (FrameLayout) this.findViewById(R.id.activity_content);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
    }

    protected FrameLayout getParentView() {
        return activityContent;
    }


    protected abstract void initViews();

    /**
     * initialize Toolbar
     *
     * @param title        : title to set to Toolbar
     * @param isHomeEnable : check is Back Button Enable or not
     */
    public void initToolBar(String title, boolean isHomeEnable) {
        mToolbar.setVisibility(View.VISIBLE);
        mTitleText.setText(title);
        mTitleText.setTypeface(Typeface.DEFAULT_BOLD);
        setSupportActionBar(mToolbar);
        if (isHomeEnable) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle(null);

        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle(null);
        }


    }

    /**
     * replace given fragment to layout
     *
     * @param fragment        fragment to replace
     * @param layoutToReplace layout which hold fragment/
     */
    public void replaceFragment(Fragment fragment, int layoutToReplace) {
        replaceFragment(fragment, layoutToReplace, true);
    }


    /**
     * override onBackPressed to maintain Fragment Stack OnBackPress
     */
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void setText(TextView view, String data) {
        if (view != null && data != null) {
            view.setText(data);
        }
    }

    public String getViewText(TextView view) {
        return view.getText().toString();
    }

    protected Toolbar getToolBar() {
        if (mToolbar == null) {
            initToolBar("", true);
        }
        return mToolbar;
    }


    public void replaceFragment(Fragment fragment, int layoutToReplace, Boolean storeInStack) {

        try {
            View view = findViewById(layoutToReplace);
            if (mLayoutId == 0) {
                if (view != null) {
                    mLayoutId = layoutToReplace;
                }
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            transaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up, 0, R.anim.slide_in_up);
            transaction.replace(mLayoutId, fragment);
            if (storeInStack) {
                transaction.addToBackStack(fragment.getClass().getCanonicalName());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replaceFragment(Fragment fragment, int layoutToReplace, boolean storeInStack, boolean isAdd) {

        try {
            View view = findViewById(layoutToReplace);
            if (mLayoutId == 0) {
                if (view != null) {
                    mLayoutId = layoutToReplace;
                }
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            if (isAdd) {
//                transaction.setCustomAnimations(R.anim.slide_out_up, R.anim.slide_in_up, 0, R.anim.slide_in_up);
                transaction.add(mLayoutId, fragment);
            } else {
                transaction.replace(mLayoutId, fragment);
            }

            if (storeInStack) {
                transaction.addToBackStack(fragment.getClass().getCanonicalName());
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setMyContentView(int layout) {
        getLayoutInflater().inflate(layout, getParentView());
    }

}
