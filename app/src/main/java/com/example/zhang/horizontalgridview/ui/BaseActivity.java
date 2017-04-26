package com.example.zhang.horizontalgridview.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.zhang.horizontalgridview.R;
import com.umeng.message.PushAgent;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 12345 on 2017/2/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 判断是否有网络连接
     * @return
     */
    private boolean checkNetworkState(){
            ConnectivityManager mConnectivityManager = (ConnectivityManager) getBaseContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
            //1.判断是否有网络连接
        if(networkInfo==null){
            return false;
        }
            boolean networkAvailable = networkInfo.isAvailable();
            //2.获取当前网络连接的类型信息
            int networkType = networkInfo.getType();
            if(ConnectivityManager.TYPE_WIFI == networkType){
                //当前为wifi网络
            }else if(ConnectivityManager.TYPE_MOBILE == networkType){
                //当前为mobile网络
            }
        return networkAvailable;
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!checkNetworkState()){
            setContentView(R.layout.networ_faile);
        }else{
            onCreate(savedInstanceState,"aa");
        }
        PushAgent.getInstance(this).onAppStart();
    }
    public abstract void onCreate(Bundle savedInstanceState,String s);

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }
}
