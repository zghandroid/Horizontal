package com.example.zhang.horizontalgridview.ui.mycustomview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhang.horizontalgridview.R;

/**
 * Created by 12345 on 2017/5/5.
 */

public class MyProgress extends ProgressDialog {
    public MyProgress(Context context) {
        super(context);
    }

    public MyProgress(Context context, int theme) {
        super(context, theme);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView = (ImageView) findViewById(R.id.my_pd_image);
        // 获取ImageView上的动画背景
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        // 开始动画
        spinner.start();
    }
    /**
     * 给Dialog设置提示信息
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.my_pd_tv).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.my_pd_tv);
            txt.setText(message);
            txt.invalidate();
        }
    }

    /**
     * 弹出自定义ProgressDialog
     *
     * @param context
     *            上下文
     * @param message
     *            提示
     * @param cancelable
     *            是否按返回键取消
     * @param cancelListener
     *            按下返回键监听
     * @return
     */
    public static MyProgress show(Context context, CharSequence message, boolean cancelable, OnCancelListener cancelListener) {
        MyProgress dialog = new MyProgress(context, R.style.MyProgress);
        dialog.setTitle("");


        // 按返回键是否取消
        dialog.setCancelable(cancelable);
        // 监听返回键处理
        dialog.setOnCancelListener(cancelListener);
        // 设置居中
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.show();
        dialog.setContentView(R.layout.lagyout_mpd);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.my_pd_tv).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.my_pd_tv);
            txt.setText(message);
        }
        return dialog;
    }
}
