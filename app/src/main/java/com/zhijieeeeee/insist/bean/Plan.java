package com.zhijieeeeee.insist.bean;

/**
 * Created by Ashin on 2018/3/24.
 */

public class Plan {

    private String name;
    private boolean done;

    public Plan(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
