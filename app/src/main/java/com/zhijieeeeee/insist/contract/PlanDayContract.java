package com.zhijieeeeee.insist.contract;

import com.haibin.calendarview.Calendar;
import com.zhijieeeeee.insist.base.presenter.AbstractPresenter;
import com.zhijieeeeee.insist.base.view.BaseView;

import java.util.List;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface PlanDayContract {

    interface View extends BaseView {

        void showDoneDateList(List<Calendar> list);

        void showDoneSum(int sum);

        void addDoneDate(Calendar calendar);
    }

    interface Presenter extends AbstractPresenter<View> {

        void getDoneDateList();

        void getDoneSum();

        void addDoneDate(Calendar doneCalendar);
    }
}
