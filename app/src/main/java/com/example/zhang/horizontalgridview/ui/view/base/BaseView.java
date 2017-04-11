package com.example.zhang.horizontalgridview.ui.view.base;

/**
 * Created by 12345 on 2017/4/6.
 */

public interface BaseView {
    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show error message
     */
    void showError(String msg);

}
