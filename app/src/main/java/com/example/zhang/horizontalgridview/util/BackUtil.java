package com.example.zhang.horizontalgridview.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class BackUtil {
	
	private static BackUtil logoutUtil;
	
	private BackUtil() {
	}
	
	public static BackUtil getInstence(){
		if (logoutUtil == null) {
			logoutUtil = new BackUtil();
		}
		
		return logoutUtil;
	}

	/**
	 * 退出程序
	 */
	
	private boolean isExit;
	
	public void exit(Context context) {
		if (!isExit) {
			isExit = true;
			Toast.makeText(context, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			mHandler.sendEmptyMessageDelayed(0, 2000);
		} else {
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.killBackgroundProcesses(context.getPackageName());
			System.exit(0);
		}

	}
	
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			isExit = false;
		}
	};
	
}
