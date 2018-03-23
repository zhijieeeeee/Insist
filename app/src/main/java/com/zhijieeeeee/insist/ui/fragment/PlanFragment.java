package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanContract;
import com.zhijieeeeee.insist.presenter.PlanPresenter;
import com.zhijieeeeee.insist.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class PlanFragment extends BaseFragment<PlanPresenter> implements PlanContract.View {

    @BindView(R.id.btn_plan)
    Button btnPlan;

    @Override
    public void showLoading() {

    }

    @Override
    public void showData(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_fragment;
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


    @OnClick(R.id.btn_plan)
    public void onViewClicked() {
        mPresenter.getData();
    }
}
