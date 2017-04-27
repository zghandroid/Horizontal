package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.ui.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.ui.fragment.MyFirstFragment;
import com.example.zhang.horizontalgridview.ui.fragment.SecondFragment;
import com.example.zhang.horizontalgridview.ui.fragment.ThirdFrament;
import com.recker.flybanner.FlyBanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12345 on 2017/3/3.
 */

public class HotPointFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private FlyBanner banner;
    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private ImageView current;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotpoint_frag, container, false);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager_frag);
        tabLayout= (TabLayout)view.findViewById(R.id.tabLayout);
        banner = (FlyBanner) view.findViewById(R.id.banner_1);
        current = (ImageView) view.findViewById(R.id.four_current);

        fragments=new ArrayList<>();
        fragments.add(new MyFirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFrament());
        tabLayout.setupWithViewPager(viewPager,true);
        tabLayout.setSelectedTabIndicatorHeight(0);
        adapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) current.getLayoutParams();
        params.leftMargin= (int) (current.getWidth()*(position+positionOffset));
        current.setLayoutParams(params);


    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
