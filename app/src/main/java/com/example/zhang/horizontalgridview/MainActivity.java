package com.example.zhang.horizontalgridview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhang.horizontalgridview.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.adapter.MyPagerAdapter;
import com.example.zhang.horizontalgridview.fragment.MyFirstFragment;
import com.example.zhang.horizontalgridview.fragment.SecondFragment;
import com.example.zhang.horizontalgridview.fragment.ThirdFrament;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, View.OnScrollChangeListener, ViewPager.OnPageChangeListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private BottomNavigationBar navigationBar;
    @Override
    public void onCreate(Bundle savedInstanceState,String s) {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragments=new ArrayList<>();
        fragments.add(new MyFirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFrament());
        adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager,true);
        for(int i=0;i<fragments.size();i++){
            tabLayout.getTabAt(i).setText("测试"+i);
        }

        initView();
        viewPager.addOnPageChangeListener(this);
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

        if(position<3) {
            viewPager.setCurrentItem(position);
        }
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

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }
}
