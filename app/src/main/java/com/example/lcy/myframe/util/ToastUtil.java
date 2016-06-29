package com.example.lcy.myframe.util;

import android.widget.Toast;

import com.example.lcy.myframe.base.BaseApplication;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class ToastUtil {
    private static Toast mToast;

    /**
     * 弹出shortToast
     * @param msg
     */
    public static void showShortToast(String msg) {
        if (msg == null) {
            msg = "";
        }
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * 弹出longToast
     * @param msg
     */
    public static void showLongToast(String msg) {
        if (msg == null) {
            msg = "";
        }
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.mContext, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

}