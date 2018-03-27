package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.SettingContract;
import com.zhijieeeeee.insist.util.SpManager;
import com.zhijieeeeee.insist.util.ToastUtil;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class SettingPresenter extends BasePresenter<SettingContract.View> implements SettingContract.Presenter {

    private SpManager spManager;

    @Inject
    public SettingPresenter(SpManager spManager) {
        this.spManager = spManager;
    }
}
