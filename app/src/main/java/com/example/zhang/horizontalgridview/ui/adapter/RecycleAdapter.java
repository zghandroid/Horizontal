package com.example.zhang.horizontalgridview.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.base.BaseRecycleAdapter;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.ListsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/17.
 */

public class RecycleAdapter extends BaseRecycleAdapter<ListsBean> {
    public RecycleAdapter(List<ListsBean> data, Context context,int layout) {
        super(data,context,layout);
    }


    @Override
    public void bindData(BaseRecycleAdapter<ListsBean>.MyBaseViewHolder holder, ListsBean listsBean) {
        SimpleDraweeView  simpleDraweeView=holder.getView(R.id.my_image_view);
        Uri uri = Uri.parse(listsBean.getBpic());
        simpleDraweeView.setImageURI(uri);
    }

}
