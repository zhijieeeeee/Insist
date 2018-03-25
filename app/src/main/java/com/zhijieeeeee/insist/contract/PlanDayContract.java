package com.zhijieeeeee.insist.contract;

import com.zhijieeeeee.insist.base.presenter.AbstractPresenter;
import com.zhijieeeeee.insist.base.view.BaseView;
import com.zhijieeeeee.insist.bean.Plan;

import java.util.List;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface PlanDayContract {

    interface View extends BaseView {

        void showPlanList(List<Plan> list);

        void notifyListChange();

        void refreshComplete();
    }

    interface Presenter extends AbstractPresenter<View> {

        void getPlanList(boolean showLoading);

        void setPlanDone(Plan plan);
    }
}
