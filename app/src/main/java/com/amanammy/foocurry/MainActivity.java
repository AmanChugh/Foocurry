package com.amanammy.foocurry;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import com.amanammy.easywork.BaseActivity;
import com.amanammy.foocurry.fragments.LeftNavigationFragment;
import com.amanammy.foocurry.fragments.RestaurantsFragment;
import com.amanammy.foocurry.listeners.OnNavigationItemClick;

public class MainActivity extends BaseActivity implements OnNavigationItemClick {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private LeftNavigationFragment mLeftNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMyContentView(R.layout.activity_main);
        initToolBar("", true);
        initViews();
        replaceFragment(RestaurantsFragment.newInstance(), R.id.nav_content, false, true);
    }

    @Override
    protected void initViews() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mLeftNavigation = (LeftNavigationFragment) getFragmentManager().findFragmentById(R.id.fragment);
//        mNavigationFragment.setOnNavigationItemClick(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, getToolBar(), R.string.blank, R.string.blank) {

            /** Called when a mDrawerLayout has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /** Called when a mDrawerLayout has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        // Set the mDrawerLayout mDrawerToggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        .setHomeButtonEnabled(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
//        return true;
//    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);

                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationItemClick(int position) {
        mDrawerLayout.closeDrawers();
    }
    }
