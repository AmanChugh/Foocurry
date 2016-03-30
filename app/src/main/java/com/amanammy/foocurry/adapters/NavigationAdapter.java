package com.amanammy.foocurry.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amanammy.foocurry.R;

/**
 * Created by amandeepsingh on 1/3/16.
 */
public class NavigationAdapter extends BaseAdapter {
    private final Context mContext;

//    Home
//            FOREWORD
//    INSTRUCTIONS
//    START READING
//    CHECK YOUR CHILD'S EYES
//    UNDERSTANDING THE RESULTS
//    BOOK AN EYE TEST

    private String[] mList = {"Restaurant"};

    public NavigationAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
//        if (convertView == null) {
        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.view_navlist, null);
        holder = new ViewHolder();
        holder.textview = (TextView) convertView.findViewById(R.id.tv_navlist);

//            convertView.setTag(holder);
//        }
//        holder = (ViewHolder) convertView.getTag();
        holder.textview.setText(mList[position]);

        return convertView;
    }

    class ViewHolder {
        TextView textview;
    }

}
