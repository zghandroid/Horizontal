package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.example.zhang.horizontalgridview.ui.Presenter.RecommendPresenter;
import com.example.zhang.horizontalgridview.ui.adapter.RecommendAdpter;
import com.example.zhang.horizontalgridview.ui.fragment.BaseFragment;
import com.example.zhang.horizontalgridview.ui.view.RecommendView;

import java.util.List;

/**
 * Created by 12345 on 2017/3/3.
 */

public class RecommFragment extends BaseFragment implements RecommendView{
    private ListView listView;
    private RecommendAdpter adpter;
    private RecommendPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recom_frag, container, false);
        listView = (ListView) view.findViewById(R.id.recomd_listview);
        adpter = new RecommendAdpter(null, R.layout.recommed_listview);
        listView.setAdapter(adpter);
        presenter = new RecommendPresenter(this, getContext());
        presenter.init();
        return view;
    }

    @Override
    public void showListView(List<HotLive> hotLives) {
         adpter.addAll(hotLives.get(0).getLists());
    }

    @Override
    public void showLoading(String msg) {
        showDialog(msg);
    }

    @Override
    public void hideLoading() {
        heidDialog();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
    }


}
