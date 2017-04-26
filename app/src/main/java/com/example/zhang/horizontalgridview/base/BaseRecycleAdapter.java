package com.example.zhang.horizontalgridview.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 12345 on 2017/4/17.
 */

public class BaseRecycleAdapter extends RecyclerView.Adapter<BaseRecycleAdapter.MyBaseViewHolder> {

    @Override
    public MyBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyBaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class MyBaseViewHolder extends RecyclerView.ViewHolder{

         public MyBaseViewHolder(View itemView) {
             super(itemView);
         }
         public View getView(int id){
             View viewById = itemView.findViewById(id);
             return viewById;
         }
     }
}
