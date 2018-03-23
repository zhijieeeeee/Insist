package com.zhijieeeeee.insist.contract;

import com.zhijieeeeee.insist.base.presenter.AbstractPresenter;
import com.zhijieeeeee.insist.base.view.BaseView;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface PlanContract {

    interface View extends BaseView {
        void showData(String msg);
    }

    interface Presenter extends AbstractPresenter<View> {
        void getData();
    }
}
