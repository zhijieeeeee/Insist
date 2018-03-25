package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.contract.PlanWeekContract;
import com.zhijieeeeee.insist.presenter.PlanDayPresenter;
import com.zhijieeeeee.insist.presenter.PlanWeekPresenter;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanWeekFragment extends BaseFragment<PlanWeekPresenter> implements PlanWeekContract.View {
    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_week_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @Override
    protected void initInject() {

    }
}
