package com.zhijieeeeee.insist.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.bean.Plan;

import java.util.List;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayAdapter extends BaseQuickAdapter<Plan, BaseViewHolder> {

    public PlanDayAdapter(@Nullable List<Plan> data) {
        super(R.layout.item_day_plan, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Plan item) {
        LinearLayout ll_plan = helper.getView(R.id.ll_plan);
        helper.setText(R.id.tv_plan, item.getName());
        if (item.isDone()) {//完成
            ll_plan.setAlpha(0.4f);
            helper.setVisible(R.id.tv_congratulation, true);
            helper.setVisible(R.id.tv_done, false);
        } else {//未完成
            ll_plan.setAlpha(1);
            helper.setVisible(R.id.tv_congratulation, false);
            helper.setVisible(R.id.tv_done, true);
            helper.addOnClickListener(R.id.tv_done);
        }
    }
}
