package com.zhijieeeeee.insist.contract;

import com.zhijieeeeee.insist.base.presenter.AbstractPresenter;
import com.zhijieeeeee.insist.base.view.BaseView;

import java.util.List;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface MainContract {

    interface View extends BaseView {
        void showData(List<String> data);
    }

    interface Presenter extends AbstractPresenter<View> {

        void getData();
    }
}
