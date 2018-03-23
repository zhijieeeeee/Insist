package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void getData() {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        mView.showData(data);
    }
}
