package com.example.zhang.horizontalgridview.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.adapter.MyFragmentAdapter;
import com.example.zhang.horizontalgridview.fragment.MyFirstFragment;
import com.example.zhang.horizontalgridview.fragment.SecondFragment;
import com.example.zhang.horizontalgridview.fragment.ThirdFrament;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by 12345 on 2017/3/3.
 */

public class HotPointFragment extends Fragment implements View.OnClickListener {

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private FlyBanner banner;
    private List<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private ImageView share;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotpoint_frag, container, false);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager_frag);
        tabLayout= (TabLayout)view.findViewById(R.id.tabLayout);
        banner = (FlyBanner) view.findViewById(R.id.banner_1);
        share = (ImageView) view.findViewById(R.id.share);
        share.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        showShare();
    }
    private void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getContext());
    }

}
