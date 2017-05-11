package com.example.zhang.horizontalgridview.ui.mycustomview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 12345 on 2017/5/10.
 */

public class MyTestScrollView extends ScrollView {
    private OnScrollChangedListener scrollChangedListener;
    public MyTestScrollView(Context context) {
        this(context,null);
    }

    public MyTestScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scrollChangedListener!=null){
            scrollChangedListener.onScrollChanged(l,t,oldl,oldt);
        }
    }

    public void setScrollChangedListener(OnScrollChangedListener scrollChangedListener) {
        this.scrollChangedListener = scrollChangedListener;
    }

    public interface OnScrollChangedListener{
            void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
