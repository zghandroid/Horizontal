package com.example.zhang.horizontalgridview.ui.view;

import com.example.zhang.horizontalgridview.ui.view.base.BaseView;

import java.util.List;

/**
 * Created by 12345 on 2017/4/14.
 */

public interface SolftView extends BaseView {

    void showRecycleView(List<VideoInfo> videoInfos);
    void updateRes();
    void addRes();

}
