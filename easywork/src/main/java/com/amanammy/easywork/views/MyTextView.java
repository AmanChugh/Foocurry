package com.amanammy.easywork.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.amanammy.easywork.R;


/**
 * Created by amandeep on 14/10/15.
 */
public class MyTextView extends TextView {

    private String mFont;

    public MyTextView(Context context) {
        super(context, null);
        init(context);
    }


    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyTextView,
                0, 0);
        try {
            mFont = a.getString(R.styleable.MyTextView_font);
        } finally {
            a.recycle();
        }
        init(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyTextView,
                0, 0);

        try {
            mFont = a.getString(R.styleable.MyTextView_font);
        } finally {
            a.recycle();
        }
        init(context);
    }

    private void init(Context context) {
        if (mFont != null) {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + mFont);
            setTypeface(tf);
        }
    }


}
