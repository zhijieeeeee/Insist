package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

}
