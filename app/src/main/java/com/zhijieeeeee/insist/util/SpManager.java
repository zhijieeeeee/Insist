package com.zhijieeeeee.insist.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhijieeeeee.insist.app.Constants;
import com.zhijieeeeee.insist.app.InsistApp;

/**
 * SharedPreferences管理类
 * Created by tangzhijie on 2018/3/27.
 */

public class SpManager {

    private SharedPreferences sp;

    public SpManager() {
        sp = InsistApp.mInstance.getSharedPreferences(Constants.SP_NAME, Context.MODE_PRIVATE);
    }

    public void setWeekPlan(String weekPlan) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("weekPlan", weekPlan);
        editor.commit();
    }

    public String getWeekPlan() {
        return sp.getString("weekPlan", "");
    }
}
