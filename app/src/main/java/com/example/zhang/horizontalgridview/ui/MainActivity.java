package com.example.zhang.horizontalgridview.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.ui.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.ui.fragment.home.GameFragment;
import com.example.zhang.horizontalgridview.ui.fragment.home.HotPointFragment;
import com.example.zhang.horizontalgridview.ui.fragment.home.ManagerFragment;
import com.example.zhang.horizontalgridview.ui.fragment.home.RecommFragment;
import com.example.zhang.horizontalgridview.ui.fragment.home.SolftFragmnet;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;
import com.example.zhang.horizontalgridview.util.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener, View.OnClickListener {

    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private BottomNavigationBar navigationBar;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ImageView share;
    private ImageView my;
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
        drawerLayout = (DrawerLayout) findViewById(R.id.my_draw);
        share = (ImageView)findViewById(R.id.share);
        share.setOnClickListener(this);
        my = (ImageView) findViewById(R.id.my);
        my.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share:
                showShare();
                break;
            case R.id.my:
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)){

                    drawerLayout.closeDrawer(Gravity.LEFT);
                }else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
    }
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://www.baidu.com/");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://www.baidu.com/");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://www.baidu.com/");

// 启动分享GUI
        oks.show(this);
    }

    private void  getMove() {
        Observer<List<VideoInfo>> observer = new Observer<List<VideoInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<VideoInfo> videoInfo) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        RetrofitUtils retrofitUtils = RetrofitUtils.getInstence();
        retrofitUtils.getMovie(observer, 0, 10);
    }

}
