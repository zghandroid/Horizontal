package com.example.zhang.horizontalgridview.util;

import com.example.zhang.horizontalgridview.ui.MovieInterface;
import com.example.zhang.horizontalgridview.http.bean.ResultDate;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;

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
    public void getMovie(Observer<List<VideoInfo>> observable, int start, int count){
        MovieInterface movieInterface=retrofit.create(MovieInterface.class);
        Observable<ResultDate<VideoInfo>> movie = movieInterface.getMovie(start, count);
        movie.map(new MoveFunc<VideoInfo>()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }

    private class MoveFunc<T> implements Function<ResultDate<T>, List<T>> {
        @Override
        public List<T> apply(@NonNull ResultDate<T> videoInfos) throws Exception {
            return videoInfos.getData();
        }
    }
}
