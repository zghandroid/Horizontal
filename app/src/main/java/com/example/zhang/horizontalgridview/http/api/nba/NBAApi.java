package com.example.zhang.horizontalgridview.http.api.nba;

import com.example.zhang.horizontalgridview.http.bean.ResultDate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 12345 on 2017/4/25.
 */

public interface NBAApi {

    @GET("/news/index")
     Call<ResultDate> getIndex(@Query("column") String column);
    @GET("/news/item")
    Call<ResultDate> getItem(@Query("column") String column,@Query("articleIds") String articleIds);
}
