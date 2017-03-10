package com.example.zhang.horizontalgridview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhang.horizontalgridview.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.fragment.home.GameFragment;
import com.example.zhang.horizontalgridview.fragment.home.HotPointFragment;
import com.example.zhang.horizontalgridview.fragment.home.ManagerFragment;
import com.example.zhang.horizontalgridview.fragment.home.RecommFragment;
import com.example.zhang.horizontalgridview.fragment.home.SolftFragmnet;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private BottomNavigationBar navigationBar;
    private ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState,String s) {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        fragments=new ArrayList<>();
        fragments.add(new HotPointFragment());
        fragments.add(new RecommFragment());
        fragments.add(new GameFragment());
        fragments.add(new ManagerFragment());
        fragments.add(new SolftFragmnet());
        adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        initView();
        viewPager.addOnPageChangeListener(this);
        ProgressDialog progressDialog = new ProgressDialog(this);

    }


    private void initView() {
        navigationBar = (BottomNavigationBar) findViewById(R.id.navigation_bar);
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");
        navigationBar.addItem(new BottomNavigationItem(R.drawable.appgroup,"热点"))
                .addItem(new BottomNavigationItem(R.drawable.home,"推荐"))
                .addItem(new BottomNavigationItem(R.drawable.game,"游戏"))
                .addItem(new BottomNavigationItem(R.drawable.manager,"管理"))
                .addItem(new BottomNavigationItem(R.drawable.software,"软件"))
                .initialise();
        navigationBar.setTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(int position) {
            viewPager.setCurrentItem(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            navigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
