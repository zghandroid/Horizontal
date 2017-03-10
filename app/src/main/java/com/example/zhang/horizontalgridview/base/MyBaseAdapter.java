package com.example.zhang.horizontalgridview.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * adapter基类
 * Created by qy on 2017/3/6.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected List<T> mData;
    protected int layoutId;

    public MyBaseAdapter(List<T> data, int layoutId){
        if (data == null) {
            mData = new ArrayList<>();
        }else{
            mData = data;
        }
        this.layoutId = layoutId;
    }

    /**
     * 更新数据源
     * @param data  传入的数据源
     */
    public void update(List<T> data) {
        if (data != null) {
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    /**
     * 加载更多的数据
     * @param data  传入的数据
     */
    public void addAll(List<T> data) {
        if (data != null) {
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bindData(getItem(position),position,viewHolder);

        return convertView;
    }


    protected abstract void bindData(T t,int position,ViewHolder holder);


   public static class ViewHolder{
       private Map<Integer,View> views;
       private View itemView;

       public ViewHolder(View view) {
           this.itemView = view;
           views = new HashMap<>();
       }

       public View getView(int id) {
           View view;
           if (views.containsKey(id)) {
               view = views.get(id);
           }else{
               view = itemView.findViewById(id);
               views.put(id, view);
           }
           return view;
       }

   }


}
