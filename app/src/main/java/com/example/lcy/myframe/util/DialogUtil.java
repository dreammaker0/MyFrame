package com.example.lcy.myframe.util;

import android.content.Context;
import android.content.DialogInterface;

import com.afollestad.materialdialogs.AlertDialogWrapper;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class DialogUtil {
    /**
     * 一般提示对话框
     * @param context 上下文
     * @param title   标题
     * @param msg     信息
     */
    public static void showAlertDialog(Context context, String title, String msg) {
        new AlertDialogWrapper.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

}
