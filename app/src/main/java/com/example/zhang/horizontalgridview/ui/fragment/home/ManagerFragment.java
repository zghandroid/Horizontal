package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.base.HeaderAndFooterWrapper;
import com.example.zhang.horizontalgridview.http.api.RequestCallBack;
import com.example.zhang.horizontalgridview.http.api.zhanqi.ZhanQiService;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.ListsBean;
import com.example.zhang.horizontalgridview.ui.adapter.RecommendAdpter;
import com.example.zhang.horizontalgridview.ui.adapter.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by 12345 on 2017/3/3.
 */

public class ManagerFragment extends Fragment implements View.OnClickListener, RecycleAdapter.OnItemClickLitener, SwipeRefreshLayout.OnRefreshListener {
    private ImageView imageView;
    private RecyclerView recyclerView;
    private RecycleAdapter adpter;
    private SwipeRefreshLayout swipeRefreshLayout;
    HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    int a=0;
    private LinearLayoutManager mLayoutManager;
    private int mItemCount, mLastCompletely, mLastLoad;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manager_frag, container, false);
        imageView = (ImageView) view.findViewById(R.id.test_image);
        imageView.setOnClickListener(this);
        adpter = new RecycleAdapter(null,getContext(), R.layout.recommed_listview);
        adpter.setOnItemClickLitener(ManagerFragment.this);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.test_swipe);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorAccent, R.color.colorPrimary,R.color.colorPrimaryDark
        );
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.manager_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
         mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(adpter);
        final ImageView t2 = new ImageView(getContext());
        t2.setImageResource(R.mipmap.ic_launcher);
        mHeaderAndFooterWrapper.addHeaderView(t2);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                     mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                    mItemCount = mLayoutManager.getItemCount();
                    mLastCompletely = mLayoutManager.findLastCompletelyVisibleItemPosition();
                } else {
                    return;
                }

                if (mLastLoad != mItemCount && mItemCount == mLastCompletely + 1) {
                    mLastLoad = mItemCount;
                    onLoadMore();
                }

            }
        });
        ZhanQiService.getHotLive(new RequestCallBack<HotLive>() {
            @Override
            public void OnSuccess(List<HotLive> t) {
                mHeaderAndFooterWrapper.addRes(t.get(a).getLists());
            }

            @Override
            public void Onfaliure(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
            }
        });
        return view;

    }

    private void onLoadMore() {
        a++;
        ZhanQiService.getHotLive(new RequestCallBack<HotLive>() {
            @Override
            public void OnSuccess(List<HotLive> t) {
                if(a>=mHeaderAndFooterWrapper.getItemCount()){
                    a=0;
                }
                mHeaderAndFooterWrapper.addRes(t.get(a).getLists());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void Onfaliure(String message) {
                a=0;
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 500f);
        animator.setInterpolator(new BounceInterpolator());
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).after(animator1);
        set.setDuration(5000);
        set.start();

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(),"点击了第"+position+"个",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(getContext(),"长点击了第"+position+"个",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRefresh() {
        a++;
        ZhanQiService.getHotLive(new RequestCallBack<HotLive>() {
            @Override
            public void OnSuccess(List<HotLive> t) {
                if(a>=mHeaderAndFooterWrapper.getItemCount()){
                    a=0;
                }
                mHeaderAndFooterWrapper.updateRes(t.get(a).getLists());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void Onfaliure(String message) {
                a=0;
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

}
