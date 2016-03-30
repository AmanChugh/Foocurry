package com.amanammy.foocurry.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amanammy.easywork.fragments.BaseFragment;
import com.amanammy.foocurry.R;
import com.amanammy.foocurry.adapters.NavigationAdapter;
import com.amanammy.foocurry.listeners.OnNavigationItemClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftNavigationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftNavigationFragment extends BaseFragment {

    private OnNavigationItemClick mOnNavigationItemClick;
    private NavigationAdapter mAdapter;

    public LeftNavigationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LeftNavigationFragment.
     */
    public static LeftNavigationFragment newInstance() {
        LeftNavigationFragment fragment = new LeftNavigationFragment();
        return fragment;
    }


    @Override
    protected void initViews(View view) {
        ListView listView = (ListView) view.findViewById(R.id.lv_fragment_navigation);
        mAdapter = new NavigationAdapter(getActivity());
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mOnNavigationItemClick != null) {
                    mOnNavigationItemClick.onNavigationItemClick(position);
                }
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left_navigation, container, false);
        initViews(view);
        return view;
    }


}
