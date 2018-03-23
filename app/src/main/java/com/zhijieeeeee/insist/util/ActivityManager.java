package com.zhijieeeeee.insist.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Description：Activity管理器
 * </p>
 *
 * @author tangzhijie
 */
public class ActivityManager {

    private static List<Activity> activityList = new ArrayList<>();

    /**
     * 添加Activity
     */
    public static void addActivity(Activity activity) {
        if (null != activity) {
            activityList.add(activity);
        }
    }

    /**
     * 移除activity
     */
    public static void removeActivity(Activity activity) {
        if (null != activity && activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }

    /**
     * 获取当前栈顶activity
     *
     * @return
     */
    public static Activity getTopActivity() {
        if (activityList.size() > 0) {
            return activityList.get(activityList.size() - 1);
        }
        return null;
    }

    /**
     * 关闭所有Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activityList.clear();
    }
}
