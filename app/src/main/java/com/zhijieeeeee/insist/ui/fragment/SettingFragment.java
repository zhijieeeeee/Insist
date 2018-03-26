package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseFragment;
import com.zhijieeeeee.insist.contract.SettingContract;
import com.zhijieeeeee.insist.presenter.SettingPresenter;

/**
 * Created by Ashin on 2018/3/24.
 */

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingContract.View {

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    protected void initInject() {
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.setting_fragment;
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
}
