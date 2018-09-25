package com.tlh.electricsystem.base.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * toast工具类
 */

public class ToastUtil {

    private static Toast mToast;
    private static Toast lToast;

    public static void showLongToast(Context context, String pMsg) {
        LongToast(context, pMsg);
    }

    private static void LongToast(Context context, String text) {
        if (lToast == null) {
            lToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            lToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            lToast.setText(text);
            lToast.setDuration(Toast.LENGTH_LONG);
        }
        lToast.show();
    }

    public static void showShortToast(Context context, String pMsg) {
        shortToast(context, pMsg);
    }

    private static void shortToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
