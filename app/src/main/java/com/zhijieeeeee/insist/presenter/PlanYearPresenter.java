package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.PlanWeekContract;
import com.zhijieeeeee.insist.contract.PlanYearContract;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanYearPresenter extends BasePresenter<PlanYearContract.View> implements PlanYearContract.Presenter {

    @Inject
    public PlanYearPresenter() {
    }
}
