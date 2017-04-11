package com.example.zhang.horizontalgridview.http.api;

import com.example.zhang.horizontalgridview.BuildConfig;

import java.util.List;

/**
 * Created by 12345 on 2017/3/21.
 */

public  interface RequestCallBack<T> {

    void OnSuccess(List<T> t);
    void Onfaliure(String message);
}
