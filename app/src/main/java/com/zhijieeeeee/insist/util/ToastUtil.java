package com.zhijieeeeee.insist.util;

import android.text.TextUtils;
import android.widget.Toast;

import com.zhijieeeeee.insist.app.InsistApp;

/**
 * <p>
 * Description：Toast工具类
 * </p>
 *
 * @author tangzhijie
 */
public class ToastUtil {

    private static Toast toast;

    public static void show(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (toast == null) {
            toast = Toast.makeText(InsistApp.mInstance, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
