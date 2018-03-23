package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.PlanContract;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class PlanPresenter extends BasePresenter<PlanContract.View> implements PlanContract.Presenter {

    @Inject
    public PlanPresenter() {
    }

    @Override
    public void getData() {
        mView.showData("开心");
    }
}
