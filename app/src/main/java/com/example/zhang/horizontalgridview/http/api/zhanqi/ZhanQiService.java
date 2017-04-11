package com.example.zhang.horizontalgridview.http.api.zhanqi;

import com.example.zhang.horizontalgridview.BuildConfig;
import com.example.zhang.horizontalgridview.http.api.RequestCallBack;
import com.example.zhang.horizontalgridview.http.bean.ResultDate;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 12345 on 2017/4/6.
 */

public class ZhanQiService {
    static Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BuildConfig.ZHANQISERVER).build();
    static ZhanQiApi api=retrofit.create(ZhanQiApi.class);

    /**
     * 获取热点直播
     * @param callBack
     */
    public static void getHotLive(final RequestCallBack<HotLive> callBack){
        Call<ResultDate<HotLive>> call = api.HotLive();
        call.enqueue(new Callback<ResultDate<HotLive>>() {
            @Override
            public void onResponse(Call<ResultDate<HotLive>> call, Response<ResultDate<HotLive>> response) {
                ResultDate<HotLive> body = response.body();
                if(!body.getCode().equals("0")){
                    callBack.Onfaliure(body.getMessage());
                }else {
                    List<HotLive> data=body.getData();
                    callBack.OnSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<ResultDate<HotLive>> call, Throwable t) {
                callBack.Onfaliure("获取数据失败");
            }
        });
    }

    public  void getBaner(){
        Call<ResultDate> banner = api.Banner();
        banner.enqueue(new Callback<ResultDate>() {
            @Override
            public void onResponse(Call<ResultDate> call, Response<ResultDate> response) {

            }

            @Override
            public void onFailure(Call<ResultDate> call, Throwable t) {

            }
        });
    }
}
