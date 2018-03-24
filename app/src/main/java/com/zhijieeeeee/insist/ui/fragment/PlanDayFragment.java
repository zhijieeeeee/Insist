package com.zhijieeeeee.insist.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseFragment;
import com.zhijieeeeee.insist.bean.Plan;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.presenter.PlanDayPresenter;
import com.zhijieeeeee.insist.ui.adapter.PlanDayAdapter;
import com.zhijieeeeee.insist.util.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayFragment extends BaseFragment<PlanDayPresenter> implements PlanDayContract.View {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    public void showLoading() {

    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_day_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void initData() {
        mPresenter.getPlanList();
    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showPlanList(List<Plan> list) {
        PlanDayAdapter planDayAdapter = new PlanDayAdapter(list);
        planDayAdapter.bindToRecyclerView(rv);
        planDayAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                new AlertDialog.Builder(mActivity)
                        .setTitle("你确定完成了吗？")
                        .setPositiveButton("完成了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("还没", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
    }
}
