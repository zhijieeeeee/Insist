package com.zhijieeeeee.insist.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.bean.Plan;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.presenter.PlanDayPresenter;
import com.zhijieeeeee.insist.ui.adapter.PlanDayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayFragment extends BaseFragment<PlanDayPresenter> implements PlanDayContract.View {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srfl)
    SwipeRefreshLayout srfl;

    private List<Plan> mList;
    private PlanDayAdapter planDayAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_day_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {
        mList = new ArrayList<>();
    }

    @Override
    public void initView() {
        //可以在布局中设置
//        rv.setLayoutManager(new LinearLayoutManager(mActivity));
        srfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getPlanList(false);
            }
        });
    }

    @Override
    public void initData() {
        planDayAdapter = new PlanDayAdapter(mList);
        planDayAdapter.bindToRecyclerView(rv);
        planDayAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                new AlertDialog.Builder(mActivity)
                        .setTitle("你确定完成了吗？")
                        .setPositiveButton("完成了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mPresenter.setPlanDone(mList.get(position));
                            }
                        })
                        .setNegativeButton("还没", null).create().show();
            }
        });
        mPresenter.getPlanList(true);
    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @Override
    public void onFragmentFirstVisible() {
        Log.i("Insist", "PlanDayFragment.onFragmentFirstVisible");
    }

    @Override
    public void onFragmentVisibleChange(boolean visible) {
        Log.i("Insist", "PlanDayFragment.visible=" + visible);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showPlanList(List<Plan> list) {
        mList.clear();
        mList.addAll(list);
        planDayAdapter.notifyDataSetChanged();
    }

    @Override
    public void notifyListChange() {
        planDayAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshComplete() {
        srfl.setRefreshing(false);
    }
}
