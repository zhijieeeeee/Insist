package com.zhijieeeeee.insist.base.presenter;

import com.zhijieeeeee.insist.base.view.BaseView;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class BasePresenter<T extends BaseView> implements AbstractPresenter<T> {

    public T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView(BaseView view) {
        this.mView = null;
    }
}
