package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.ui.adapter.SolftAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12345 on 2017/3/3.
 */

public class SolftFragmnet extends Fragment {
    private ListView listView;
    private SolftAdapter adapter;
    private List<VideoInfo> videoInfos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.solft_frag,container,false);
        listView = (ListView) view.findViewById(R.id.solt_list);
        videoInfos = new ArrayList<>();
        VideoInfo v1=new VideoInfo("1","http://bjhlg.live.cuctv.com/cuctv_hls/yyxy.m3u8","");
        VideoInfo v2=new VideoInfo("2","http://test.mv01.cuctv.com/M00/08/3B/cR9D6FQYEST4SAX6AApHCPQzW4s968_s.mp4","");
        VideoInfo v3=new VideoInfo("3","http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","");
        VideoInfo v4=new VideoInfo("4","http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","");
        VideoInfo v5=new VideoInfo("5","http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","");
        VideoInfo v6=new VideoInfo("6","http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","");
        VideoInfo v7=new VideoInfo("7","http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","");
        videoInfos.add(v1);
        videoInfos.add(v2);
        videoInfos.add(v3);
        videoInfos.add(v4);
        videoInfos.add(v5);
        videoInfos.add(v6);
        videoInfos.add(v7);
        adapter = new SolftAdapter(videoInfos, R.layout.video);
        listView.setAdapter(adapter);
        return view;

    }
}
