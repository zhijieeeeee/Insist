package com.zhijieeeeee.insist.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.orhanobut.logger.Logger;
import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.MainContract;


import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter, LifecycleObserver {

    @Inject
    public MainPresenter() {
    }

    //implements  LifecycleObserver
    //绑定了MainActivity的生命周期，MainActivity的onCreate调用后，该方法会回调
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

}
