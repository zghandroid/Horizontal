package com.example.zhang.horizontalgridview.util;

import com.example.zhang.horizontalgridview.http.bean.VideoInfo;
import com.example.zhang.horizontalgridview.ui.MovieInterface;
import com.example.zhang.horizontalgridview.http.bean.ResultDate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 12345 on 2017/3/13.
 */

public class RetrofitUtils {
    private  Retrofit retrofit;
    private static RetrofitUtils retrofitUtils;
    private RetrofitUtils (){
        getRetrofit();
    }
    public static RetrofitUtils getInstence(){
        if(retrofitUtils==null){
            retrofitUtils=new RetrofitUtils();
        }
        return retrofitUtils;
    }
    private  void getRetrofit(){
        if(retrofit==null){
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
            retrofit=new Retrofit.Builder().baseUrl("https://api.douban.com/v2/movie/").
                    client(httpClientBuilder.build()).
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                    build();
        }
    }
    private class MoveFunc<T> implements Function<ResultDate<T>, List<T>> {
        @Override
        public List<T> apply(@NonNull ResultDate<T> videoInfos) throws Exception {
            return videoInfos.getData();
        }
    }
    public void getRel(VideoInfo real){
        if (real.vl.vi != null && real.vl.vi.size() > 0) {
            String vid = real.vl.vi.get(0).vid;
            String vkey = real.vl.vi.get(0).fvkey;
            String url = real.vl.vi.get(0).ul.ui.get(0).url + vid + ".mp4?vkey=" + vkey;
        }
    }
}
