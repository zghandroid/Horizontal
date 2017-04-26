package com.example.zhang.horizontalgridview.http.bean.nba;

/**
 * Created by 12345 on 2017/4/25.
 */

public class NBAData<T> {
    private String code;
    private T data;

    public NBAData() {
    }

    public NBAData(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
