package com.zhijieeeeee.insist.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ashin on 2018/3/25.
 */

public class DateUtil {

    public static String getNowDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
