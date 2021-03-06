package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanYearContract;
import com.zhijieeeeee.insist.presenter.PlanYearPresenter;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanYearFragment extends BaseFragment<PlanYearPresenter> implements PlanYearContract.View {

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_year_fragment;
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
    public void onFragmentFirstVisible() {
        Log.i("Insist", "PlanYearFragment.onFragmentFirstVisible");
    }

    @Override
    public void onFragmentVisibleChange(boolean visible) {
        Log.i("Insist", "PlanYearFragment.visible="+visible);
    }

    @Override
    protected void initInject() {

    }
}
