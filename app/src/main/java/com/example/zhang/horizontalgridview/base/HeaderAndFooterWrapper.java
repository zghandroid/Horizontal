package com.example.zhang.horizontalgridview.base;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;


public class HeaderAndFooterWrapper<T> extends BaseRecycleAdapter
{
    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;

    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFootViews = new SparseArrayCompat<>();

    private BaseRecycleAdapter mInnerAdapter;

    public HeaderAndFooterWrapper(BaseRecycleAdapter mInnerAdapter) {
        super(mInnerAdapter.getData(), mInnerAdapter.getContext(), mInnerAdapter.getMultiItemTypeSupport());
        this.mInnerAdapter=mInnerAdapter;
    }


    private boolean isHeaderViewPos(int position)
    {
        return position < getHeadersCount();
    }

    private boolean isFooterViewPos(int position)
    {
        return position >= getHeadersCount() + getRealItemCount();
    }


    public void addHeaderView(View view)
    {
        mHeaderViews.put(mHeaderViews.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addFootView(View view)
    {
        mFootViews.put(mFootViews.size() + BASE_ITEM_TYPE_FOOTER, view);
    }

    public int getHeadersCount()
    {
        return mHeaderViews.size();
    }

    public int getFootersCount()
    {
        return mFootViews.size();
    }


    @Override
    public BaseRecycleAdapter.MyBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (mHeaderViews.get(viewType) != null)
        {
             return new BaseRecycleAdapter.MyBaseViewHolder(mHeaderViews.get(viewType));
        } else if (mFootViews.get(viewType) != null)
        {
            return new BaseRecycleAdapter.MyBaseViewHolder(mFootViews.get(viewType));
        }
        return mInnerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(int position)
    {
        if (isHeaderViewPos(position))
        {
            return mHeaderViews.keyAt(position);
        } else if (isFooterViewPos(position))
        {
            return mFootViews.keyAt(position - getHeadersCount() - getRealItemCount());
        }
        return mInnerAdapter.getItemViewType(position - getHeadersCount());
    }

    private int getRealItemCount()
    {
        return mInnerAdapter.getItemCount();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (isHeaderViewPos(position))
        {
            return;
        }
        if (isFooterViewPos(position))
        {
            return;
        }
        mInnerAdapter.onBindViewHolder(holder, position - getHeadersCount());
    }

    @Override
    public int getItemCount()
    {
        return getHeadersCount() + getFootersCount() + getRealItemCount();
    }

    @Override
    public void bindData(BaseRecycleAdapter.MyBaseViewHolder holder, Object o) {
                mInnerAdapter.bindData(holder,o);
    }

    public class MyBaseViewHolder extends RecyclerView.ViewHolder{
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

}