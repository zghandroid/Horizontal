package com.example.zhang.horizontalgridview.ui;

import com.example.zhang.horizontalgridview.http.bean.ResultDate;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 12345 on 2017/3/14.
 */

public interface MovieInterface {
    @GET("top250")
    Observable<ResultDate<VideoInfo>> getMovie(@Query("start") int start, @Query("count") int count);

}
