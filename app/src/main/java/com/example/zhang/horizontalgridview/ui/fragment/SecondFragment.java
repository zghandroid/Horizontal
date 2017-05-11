package com.example.zhang.horizontalgridview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.ui.mycustomview.PieData;
import com.example.zhang.horizontalgridview.ui.mycustomview.PieView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 12345 on 2017/2/28.
 */

public class SecondFragment extends Fragment {
    private PieView pieView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpager2,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        pieView = (PieView) view.findViewById(R.id.mPieView);
        ArrayList<PieData> data = new ArrayList<>();
        for(int i=0;i<10;i++){
            PieData pieData=new PieData("11",30+i*10);
            data.add(pieData);
        }
        pieView.setData(data);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
