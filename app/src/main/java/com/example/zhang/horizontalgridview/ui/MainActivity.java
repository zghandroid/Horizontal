package com.example.zhang.horizontalgridview.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
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
import com.example.zhang.horizontalgridview.ui.mycustomview.MyProgress;
import com.example.zhang.horizontalgridview.util.L;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener, View.OnClickListener {

    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private BottomNavigationBar navigationBar;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ImageView share;
    private ImageView my;
    private Timer timer;
    private MyProgress progress;

    @Override
    public void onCreate(Bundle savedInstanceState, String s) {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        fragments.add(new HotPointFragment());
        fragments.add(new RecommFragment());
        fragments.add(new GameFragment());
        fragments.add(new ManagerFragment());
        fragments.add(new SolftFragmnet());
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        initView();
        viewPager.addOnPageChangeListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.my_draw);
        share = (ImageView) findViewById(R.id.share);
        share.setOnClickListener(this);
        my = (ImageView) findViewById(R.id.my);
        my.setOnClickListener(this);
        testTimer();
        progress = MyProgress.show(this, "正在加载", false, null);
        testRxJava3();
    }


    private void testTimer() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (progress != null && progress.isShowing()) {
                    progress.dismiss();
                }
                Log.e("aaa", "计时器");
            }
        };
        timer.schedule(timerTask, 2000);
    }

    private void initView() {
        navigationBar = (BottomNavigationBar) findViewById(R.id.navigation_bar);
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");
        navigationBar.addItem(new BottomNavigationItem(R.drawable.appgroup, "热点"))
                .addItem(new BottomNavigationItem(R.drawable.home, "推荐"))
                .addItem(new BottomNavigationItem(R.drawable.game, "游戏"))
                .addItem(new BottomNavigationItem(R.drawable.manager, "管理"))
                .addItem(new BottomNavigationItem(R.drawable.software, "软件"))
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
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {

                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
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

    public void testRxJava() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("Hello World!!");
                e.onComplete();
            }
        });
        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                L.d(s);
            }
        });
        observable.subscribeOn(new Scheduler() {
            @Override
            public Worker createWorker() {
                return null;
            }
        });
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                L.d(s + "Observer");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void testRxJava2() {
        Flowable.just("Hello World").subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(String s) {
                L.d(s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
        Flowable.just("Hello World 2").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                L.d(s);
            }
        });
        Flowable.just("map").map(new Function<String, String>() {
            @Override
            public String apply(@NonNull String s) throws Exception {
                return s + "Hello World";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                L.d(s);
            }
        });
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        Flowable.just(data).flatMap(new Function<List<Integer>, Publisher<Integer>>() {
            @Override
            public Publisher<Integer> apply(@NonNull List<Integer> integers) throws Exception {
                return Flowable.fromIterable(integers);
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {
                if (integer > 2) {
                    return false;
                } else {
                    return true;
                }
            }
        }).take(2).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                L.d("我在你之前" + integer);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                L.d(integer + "ddd");

            }
        });
    }

    private void testRxJava3() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("将在5秒之后显示");
                SystemClock.sleep(5000);
                e.onNext("Hello World");
            }
        }, BackpressureStrategy.BUFFER)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                L.d(s);
            }
        })
        ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


}
