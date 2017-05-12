package com.example.zhang.horizontalgridview.http.api.nba;

import com.example.zhang.horizontalgridview.http.bean.ResultDate;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 12345 on 2017/4/25.
 */

public interface NBAApi {

    /**
     *获取数据
     *
     videos:视频
     banner:头条
     news:新闻
     depth:最佳
     highlight:花絮
     * @param column
     * @return
     */
    @GET("/news/index")
    Flowable<String> getIndex(@Query("column") String column);

    /**
     *
     * @param column
     * @param articleIds
     * @return
     */
    @GET("/news/item")
    Flowable<String> getItem(@Query("column") String column,@Query("articleIds") String articleIds);
    /**
     * 最新方法
     * http://h5vv.video.qq.com/getinfo?callback=tvp_request_getinfo_callback_340380&platform=11001&charge=0&otype=json&ehost=http%3A%2F%2Fv.qq.com&sphls=0&sb=1&nocache=0&_rnd=1474896074003&vids=m0022ect1qs&defaultfmt=auto&&_qv_rmt=CTWS8OLbA17867igt=&_qv_rmt2=x6oMojAw144904luQ=&sdtfrom=v3010&callback=tvp_request_getinfo_callback_
     *
     * @param vids
     * @return
     */
    @GET("getinfo?platform=11001&charge=0&otype=json")
    Flowable<String> getVideoRealUrls(@Query("vids") String vids);

}
