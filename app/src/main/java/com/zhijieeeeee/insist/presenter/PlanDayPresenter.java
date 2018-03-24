package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.bean.Plan;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.contract.SettingContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayPresenter extends BasePresenter<PlanDayContract.View> implements PlanDayContract.Presenter {

    @Inject
    public PlanDayPresenter() {
    }

    @Override
    public void getPlanList() {
        List<Plan> list = new ArrayList<>();
        list.add(new Plan("得到", true));
        list.add(new Plan("健身", true));
        list.add(new Plan("1小时英语", false));
        mView.showPlanList(list);
    }
}
