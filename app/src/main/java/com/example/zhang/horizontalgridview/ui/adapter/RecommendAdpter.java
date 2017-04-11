package com.example.zhang.horizontalgridview.ui.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.base.MyBaseAdapter;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.ListsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/6.
 */

public class RecommendAdpter extends MyBaseAdapter<ListsBean> {

    public RecommendAdpter(List<ListsBean> data, int layoutId) {
        super(data, layoutId);
    }

    @Override
    protected void bindData(ListsBean hotLive, int position, ViewHolder holder) {
        SimpleDraweeView imageView = (SimpleDraweeView) holder.getView(R.id.my_image_view);
        Uri uri = Uri.parse(hotLive.getBpic());
        imageView.setImageURI(uri);
    }
}
