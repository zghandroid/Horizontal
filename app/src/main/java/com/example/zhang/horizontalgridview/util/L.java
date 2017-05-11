package com.example.zhang.horizontalgridview.util;

import android.util.Log;


/**
 * Created by 12345 on 2017/5/3.
 */

public class L {
    private static String LOG_NAME = "test";
    private static boolean IS_LOG=true;

//默认
    public static void e(String msg){
        if (IS_LOG) {
            Log.e(LOG_NAME, msg);
        }
    }
    public static void d(String msg){
        if (IS_LOG) {
            Log.d(LOG_NAME, msg);
        }
    }
    public static void i(String msg){
        if (IS_LOG) {
            Log.i(LOG_NAME, msg);
        }
    }
    public static void v(String msg){
        if (IS_LOG) {
            Log.v(LOG_NAME, msg);
        }
    }
    public static void w(String msg){
        if (IS_LOG) {
            Log.w(LOG_NAME, msg);
        }
    }
//类名
    public static void e(Object o,String msg){
        if (IS_LOG) {
            Log.e(o.getClass().getName(), msg);
        }
    }
    public static void d(Object o,String msg){
        if (IS_LOG) {
            Log.d(o.getClass().getName(), msg);
        }
    }
    public static void i(Object o,String msg){
        if (IS_LOG) {
            Log.i(o.getClass().getName(), msg);
        }
    }
    public static void v(Object o,String msg){
        if (IS_LOG) {
            Log.v(o.getClass().getName(), msg);
        }
    }
    public static void w(Object o,String msg){
        if (IS_LOG) {
            Log.w(o.getClass().getName(), msg);
        }
    }
//自定义
    public static void e(String o,String msg){
        if (IS_LOG) {
            Log.e(o.getClass().getName(), msg);
        }
    }
    public static void d(String o,String msg){
        if (IS_LOG) {
            Log.d(o, msg);
        }
    }
    public static void i(String o,String msg){
        if (IS_LOG) {
            Log.i(o, msg);
        }
    }
    public static void v(String o,String msg){
        if (IS_LOG) {
            Log.v(o, msg);
        }
    }
    public static void w(String o,String msg){
        if (IS_LOG) {
            Log.w(o, msg);
        }
    }
}
