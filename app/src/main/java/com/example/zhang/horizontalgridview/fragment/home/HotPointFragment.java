package com.example.zhang.horizontalgridview.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.fragment.MyFirstFragment;
import com.example.zhang.horizontalgridview.fragment.SecondFragment;
import com.example.zhang.horizontalgridview.fragment.ThirdFrament;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12345 on 2017/3/3.
 */

public class HotPointFragment extends Fragment {

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private FlyBanner banner;
    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotpoint_frag, container, false);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager_frag);
        tabLayout= (TabLayout)view.findViewById(R.id.tabLayout);
        banner = (FlyBanner) view.findViewById(R.id.banner_1);
        fragments=new ArrayList<>();
        fragments.add(new MyFirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFrament());
        tabLayout.setupWithViewPager(viewPager,true);
        adapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        for(int i=0;i<fragments.size();i++){
            tabLayout.getTabAt(i).setText("测试"+i);
        }
        testBanner();
        return view;

    }
    private void testBanner() {
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("https://img1.zhanqi.tv/uploads/2016/12/recommendspic-2016120816053120928.jpeg");
        imgesUrl.add("https://img1.zhanqi.tv/uploads/2017/02/recommendspic-2017022816025891213.jpeg");
        imgesUrl.add("https://img2.zhanqi.tv/uploads/2016/06/recommendspic-2016062122385457542.jpeg");
        imgesUrl.add("https://img2.zhanqi.tv/uploads/2016/09/recommendspic-2016092917571670724.jpeg");

        banner.setImagesUrl(imgesUrl);

        banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });

    }

}
