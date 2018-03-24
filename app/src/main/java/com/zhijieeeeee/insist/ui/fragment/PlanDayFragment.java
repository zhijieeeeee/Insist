package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanContract;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.presenter.PlanDayPresenter;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayFragment extends BaseFragment<PlanDayPresenter> implements PlanDayContract.View {
    @Override
    public void showLoading() {

    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_day_fragment;
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
