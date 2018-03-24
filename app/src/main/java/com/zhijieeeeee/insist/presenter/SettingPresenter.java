package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.SettingContract;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class SettingPresenter extends BasePresenter<SettingContract.View> implements SettingContract.Presenter {

    @Inject
    public SettingPresenter() {
    }
}
