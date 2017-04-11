package com.example.zhang.horizontalgridview.ui.view;

import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.example.zhang.horizontalgridview.ui.view.base.BaseView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/6.
 */

public interface RecommendView extends BaseView {
        void showListView(List<HotLive> hotLives);
}
