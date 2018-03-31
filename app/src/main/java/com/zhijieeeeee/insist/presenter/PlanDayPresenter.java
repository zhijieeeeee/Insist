package com.zhijieeeeee.insist.presenter;

import com.haibin.calendarview.Calendar;
import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.bean.Scheme;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.util.DataManager;
import com.zhijieeeeee.insist.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayPresenter extends BasePresenter<PlanDayContract.View> implements PlanDayContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public PlanDayPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getDoneDateList() {
        mView.showLoading();
        mDataManager.getDoneDateList(new DataManager.OnGetDoneDateListener() {
            @Override
            public void onSuccess(List<Scheme> schemes) {
                List<Calendar> calendars = new ArrayList<>();
                for (Scheme scheme : schemes) {
                    Calendar calendar = new Calendar();
                    calendar.setYear(scheme.getYear());
                    calendar.setMonth(scheme.getMonth());
                    calendar.setDay(scheme.getDay());
                    calendar.setSchemeColor(0xFFdf1356);//如果单独标记颜色、则会使用这个颜色
                    calendars.add(calendar);
                }
                mView.showDoneDateList(calendars);
                mView.closeLoading();
            }

            @Override
            public void onFail(String reason) {
                List<Calendar> calendars = new ArrayList<>();
                mView.showDoneDateList(calendars);
                mView.closeLoading();
            }
        });
    }

    @Override
    public void getDoneSum() {
        mDataManager.getDoneSum(new DataManager.OnGetDoneSumListener() {
            @Override
            public void onSuccess(int sum) {
                mView.showDoneSum(sum);
            }
        });
    }

    @Override
    public void addDoneDate(final Calendar doneCalendar) {
        mView.showLoading();
        mDataManager.addDoneDate(doneCalendar.getYear(), doneCalendar.getMonth(), doneCalendar.getDay(), new DataManager.OnAddDoneDateListener() {
            @Override
            public void onInsertSuccess(Scheme scheme) {
                doneCalendar.setSchemeColor(0xFFdf1356);//如果单独标记颜色、则会使用这个颜色
                mView.addDoneDate(doneCalendar);
                mView.closeLoading();
                ToastUtil.show("干得漂亮，继续加油");
            }

            @Override
            public void onInsertFail(String failReason) {
                ToastUtil.show(failReason);
                mView.closeLoading();
            }
        });
    }
}
