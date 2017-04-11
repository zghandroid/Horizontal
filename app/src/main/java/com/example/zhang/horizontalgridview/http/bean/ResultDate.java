package com.example.zhang.horizontalgridview.http.bean;

import java.util.List;

/**
 * Created by 12345 on 2017/3/14.
 */

public class ResultDate<T> {
    private String code;
    private String message;
    private List<T> data;

    public ResultDate() {
    }

    public ResultDate(String code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
