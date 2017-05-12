package com.example.zhang.horizontalgridview.http.api.zhanqi;

import com.example.zhang.horizontalgridview.BuildConfig;
import com.example.zhang.horizontalgridview.http.api.RequestCallBack;
import com.example.zhang.horizontalgridview.http.bean.ResultDate;
import com.example.zhang.horizontalgridview.http.bean.zhanqi.HotLive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 12345 on 2017/4/6.
 */

public class ZhanQiService {
    static Retrofit retrofit = new Retrofit.Builder().
            addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
            addConverterFactory(GsonConverterFactory.create()).
            baseUrl(BuildConfig.ZHANQISERVER).
            build();
    static ZhanQiApi api = retrofit.create(ZhanQiApi.class);

    /**
     * 获取热点直播
     *
     * @param callBack
     */
    public static void getHotLive(final RequestCallBack<HotLive> callBack) {
        Call<ResultDate<HotLive>> call = api.HotLive();
        call.enqueue(new Callback<ResultDate<HotLive>>() {
            @Override
            public void onResponse(Call<ResultDate<HotLive>> call, Response<ResultDate<HotLive>> response) {
                ResultDate<HotLive> body = response.body();
                if (!body.getCode().equals("0")) {
                    callBack.Onfaliure(body.getMessage());
                } else {
                    List<HotLive> data = body.getData();
                    callBack.OnSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<ResultDate<HotLive>> call, Throwable t) {
                callBack.Onfaliure("获取数据失败");
            }
        });
    }


    public void getBaner() {
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
    public void test(){
        Flowable<String> test = api.test("1");
        test.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                               @Override
                               public void onSubscribe(Subscription s) {
                                   s.request(Long.MAX_VALUE);
                               }

                               @Override
                               public void onNext(String s) {

                               }

                               @Override
                               public void onError(Throwable t) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }
}
