package com.example.zhang.horizontalgridview.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhang.horizontalgridview.ui.adapter.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleViewAdapter基类
 * Created by 12345 on 2017/4/17.
 */

public abstract class BaseRecycleAdapter<T> extends   RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> data;
    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private MultiItemTypeSupport multiItemTypeSupport;
    private RecycleAdapter.OnItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(RecycleAdapter.OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    public BaseRecycleAdapter(List<T> data, Context context,MultiItemTypeSupport multiItemTypeSupport) {
        super();
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.multiItemTypeSupport = multiItemTypeSupport;
    }

    public BaseRecycleAdapter(List<T> data, Context context, int layoutId) {
        if(data!=null){
            this.data=data;
        }else {
            this.data = new ArrayList<>();
        }
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }

    @Override
    public MyBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = -1;
        if(multiItemTypeSupport!=null){
            layoutId = multiItemTypeSupport.getLayoutId(viewType);
        }else {
            layoutId=this.layoutId;
        }
        final MyBaseViewHolder holder = new MyBaseViewHolder(inflater.inflate(layoutId,parent,false));
        if(onItemClickLitener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLitener.onItemLongClick(holder.itemView,pos);
                    return true;
                }
            });
        }
        return holder ;
    }

    @Override
    public int getItemViewType(int position) {
        if(multiItemTypeSupport!=null){
           return multiItemTypeSupport.getItemViewType(position,data.get(position));
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindData((MyBaseViewHolder) holder,data.get(position));
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }
    public void addRes(List<T> data){
            if(data!=null){
                this.data.addAll(data);
                notifyDataSetChanged();
            }
    }
    public void updateRes(List<T> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    /**
     * 绑定数据
     * @param holder
     * @param t
     */
    public abstract void bindData(MyBaseViewHolder holder, T t);


    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
    protected class MyBaseViewHolder extends RecyclerView.ViewHolder{
        private SparseArray<View> mViews;

        public MyBaseViewHolder(View itemView) {
            super(itemView);

            mViews=new SparseArray<View>();
        }

        /**
         * 通过viewId获取控件
         *
         * @param viewId
         * @return
         */
        public <T extends View> T getView(int viewId)
        {
            View view = mViews.get(viewId);
            if (view == null)
            {
                view = itemView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }
    }

    public interface MultiItemTypeSupport<T>
    {
        int getLayoutId(int itemType);

        int getItemViewType(int position, T t);
    }
}
