package com.zhijieeeeee.insist.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Button;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseActivity;
import com.zhijieeeeee.insist.contract.MainContract;
import com.zhijieeeeee.insist.presenter.MainPresenter;
import com.zhijieeeeee.insist.ui.fragment.PlanFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.btn)
    Button btn;

    private FragmentManager fm;
    private PlanFragment planFragment;

    @Override
    public void showLoading() {

    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        planFragment = new PlanFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_container, planFragment, "TAG");
        ft.commit();
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
        getActivityComponent().inject(this);
    }

    @Override
    public void showData(List<String> data) {
        for (String msg : data) {
            Log.d("Insist", msg);
        }
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        mPresenter.getData();
    }
}
