package com.zhijieeeeee.insist.base.presenter;

import com.zhijieeeeee.insist.base.view.BaseView;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface AbstractPresenter<T extends BaseView> {

    /**
     * 关联view层
     */
    void attachView(T view);

    /**
     * 与view层取消关联
     */
    void detachView(T view);
}
