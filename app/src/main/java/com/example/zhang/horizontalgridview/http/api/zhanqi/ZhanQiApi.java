package com.example.zhang.horizontalgridview.http.api.zhanqi;

import com.example.zhang.horizontalgridview.http.bean.ResultDate;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 12345 on 2017/4/6.
 */

public interface ZhanQiApi {
    /**
     * 后缀
     */
    String URL_SUFFIX = "?ver=2.6.6&os=3&time1461254294614";
    @GET("static/live.index/recommend-apps.json")
    /**
     * 热门直播
     */
    Call<ResultDate<HotLive>> HotLive();

    /**
     * 首页轮播
     * @return
     */
    @GET("touch/apps.banner")
    Call<ResultDate> Banner();
    /**
     * 游戏
     */
    @GET("static/game.lists/{page}")
    Call<String> Game(@Path("page") String page);

}
