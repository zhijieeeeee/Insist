package com.zhijieeeeee.insist.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class Plan extends BmobObject{

    private String day;
    private String name;
    private int done;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
