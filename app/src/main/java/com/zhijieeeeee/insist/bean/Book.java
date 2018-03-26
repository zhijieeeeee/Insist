package com.zhijieeeeee.insist.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by tangzhijie on 2018/3/26.
 */

public class Book extends BmobObject {
    private String name;
    private String startDate;
    private String endDate;
    //0正在读，1读完了
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
