package com.example.lcy.myframe.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;

import com.example.lcy.myframe.base.BaseAppManager;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class DoubleClickExitUtil {
    private final Activity mActivity;
    private boolean isOnKeyBacking;
    private Handler mHandler;

    public DoubleClickExitUtil(Activity activity) {
        mActivity = activity;
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * Activity onKeyDown事件
     * */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode != KeyEvent.KEYCODE_BACK) {
            return false;
        }
        if(isOnKeyBacking) {
            mHandler.removeCallbacks(onBackTimeRunnable);
            mActivity.finish();
            BaseAppManager.getInstance().clear();
            return true;
        } else {
            isOnKeyBacking = true;
            ToastUtil.showShortToast("再按一次退出程序");
            //延迟两秒的时间，把Runable发出去
            mHandler.postDelayed(onBackTimeRunnable, 2000);
            return true;
        }
    }

    private Runnable onBackTimeRunnable = new Runnable() {
        @Override
        public void run() {
            isOnKeyBacking = false;
        }
    };
}
