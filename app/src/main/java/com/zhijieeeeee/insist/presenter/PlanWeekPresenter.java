package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.contract.PlanWeekContract;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanWeekPresenter extends BasePresenter<PlanWeekContract.View> implements PlanWeekContract.Presenter {

    @Inject
    public PlanWeekPresenter() {
    }
}
