package com.zhijieeeeee.insist.presenter;

import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.bean.Plan;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.util.DataManager;
import com.zhijieeeeee.insist.util.ToastUtil;

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
    public void getPlanList(boolean showLoading) {
        if (showLoading) {
            mView.showLoading();
        }
        mDataManager.getCurrentDayPlan(new DataManager.OnFindCurrentDayPlanListener() {
            @Override
            public void onGetCurrentDayPlanSuccess(List<Plan> plans) {
                mView.showPlanList(plans);
                mView.closeLoading();
                mView.refreshComplete();
            }

            @Override
            public void onGetCurrentDayPlanFail() {
                //没有数据，就先插入每日的任务，再获取
                mDataManager.insertCurrentDayPlan(new DataManager.OnInsertListener() {
                    @Override
                    public void onInsertSuccess() {
                        getPlanList(false);
                    }

                    @Override
                    public void onInsertFail(String failReason) {
                        ToastUtil.show(failReason);
                        mView.closeLoading();
                        mView.refreshComplete();
                    }
                });
            }
        });
    }

    @Override
    public void setPlanDone(Plan plan) {
        mView.showLoading();
        mDataManager.setPlanDone(plan, new DataManager.OnUpdateListener() {
            @Override
            public void onUpdateSuccess() {
                mView.notifyListChange();
                mView.closeLoading();
            }
        });
    }
}
