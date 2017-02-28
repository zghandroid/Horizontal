package com.example.zhang.horizontalgridview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<View> views;
    private MyPagerAdapter adapter;
    private BottomNavigationBar navigationBar;
    @Override
    public void onCreate(Bundle savedInstanceState,String s) {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        views=new ArrayList<>();
        LayoutInflater inflater=getLayoutInflater();
        View view1=inflater.inflate(R.layout.viewpager1,null);
        View view2=inflater.inflate(R.layout.viewpager2,null);
        View view3=inflater.inflate(R.layout.viewpager3,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        adapter = new MyPagerAdapter(views);
        viewPager.setAdapter(adapter);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager,true);
        for(int i=0;i<views.size();i++){
            tabLayout.getTabAt(i).setText("测试"+i);
        }

        initView();
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

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
