package com.example.zhang.horizontalgridview.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.ListsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private int layout;
    private List<ListsBean> data;


    public RecycleAdapter( List<ListsBean> data,int layout) {
        this.layout = layout;
        this.data = data;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Uri uri = Uri.parse(data.get(position).getBpic());
        holder.imageView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.my_image_view);
        }
    }


}
