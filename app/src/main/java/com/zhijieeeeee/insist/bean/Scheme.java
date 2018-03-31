package com.zhijieeeeee.insist.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Ashin on 2018/3/31.
 */

public class Scheme extends BmobObject {
    private int  year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
