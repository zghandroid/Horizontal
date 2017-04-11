package com.example.zhang.horizontalgridview.ui.Presenter;

import android.content.Context;

import com.example.zhang.horizontalgridview.http.api.RequestCallBack;
import com.example.zhang.horizontalgridview.http.api.zhanqi.ZhanQiService;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.example.zhang.horizontalgridview.ui.view.RecommendView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/6.
 */

public class RecommendPresenter implements Presenter{
    private RecommendView recommendView;
    private Context context;

    public RecommendPresenter(RecommendView recommendView, Context context) {
        this.recommendView = recommendView;
        this.context = context;
    }

    @Override
    public void init() {
        recommendView.showLoading("");
        ZhanQiService.getHotLive(new RequestCallBack<HotLive>() {
            @Override
            public void OnSuccess(List<HotLive> t) {
                recommendView.showListView(t);
                recommendView.hideLoading();
            }

            @Override
            public void Onfaliure(String message) {
                recommendView.showError(message);
            }
        });
    }
}
