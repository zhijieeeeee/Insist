package com.zhijieeeeee.insist.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanDayContract;
import com.zhijieeeeee.insist.presenter.PlanDayPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashin on 2018/3/24.
 */

public class PlanDayFragment extends BaseFragment<PlanDayPresenter> implements PlanDayContract.View {

    @BindView(R.id.tv_sum)
    TextView tvSum;
    @BindView(R.id.tv_month_day)
    TextView tvMonthDay;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_lunar)
    TextView tvLunar;
    @BindView(R.id.ib_calendar)
    ImageView ibCalendar;
    @BindView(R.id.tv_current_day)
    TextView tvCurrentDay;
    @BindView(R.id.fl_current)
    FrameLayout flCurrent;
    @BindView(R.id.calendarView)
    CalendarView calendarView;

    private int mYear;
    private List<Calendar> mDoneDateList;
    private int sum;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_day_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {
    }

    @Override
    public void initView() {
        calendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(final Calendar calendar, boolean isClick) {
                tvLunar.setVisibility(View.VISIBLE);
                tvYear.setVisibility(View.VISIBLE);
                tvMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
                tvYear.setText(String.valueOf(calendar.getYear()));
                tvLunar.setText(calendar.getLunar());
                mYear = calendar.getYear();
                if (mDoneDateList != null && !mDoneDateList.contains(calendar) && calendar.isCurrentDay()) {
                    new AlertDialog.Builder(mActivity)
                            .setTitle("你确定完成了吗？")
                            .setPositiveButton("完成了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mPresenter.addDoneDate(calendar);
                                }
                            })
                            .setNegativeButton("还没", null).create().show();
                }
            }
        });
        calendarView.setOnYearChangeListener(new CalendarView.OnYearChangeListener() {
            @Override
            public void onYearChange(int year) {
                tvMonthDay.setText(String.valueOf(year));
            }
        });

        mYear = calendarView.getCurYear();
        tvYear.setText(calendarView.getCurYear() + "");
        tvMonthDay.setText(calendarView.getCurMonth() + "月" + calendarView.getCurDay() + "日");
        tvLunar.setText("今日");
        tvCurrentDay.setText(String.valueOf(calendarView.getCurDay()));
    }

    @Override
    public void initData() {
        mPresenter.getDoneDateList();
        mPresenter.getDoneSum();
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
    public void showDoneDateList(List<Calendar> list) {
        mDoneDateList = list;
        calendarView.setSchemeDate(mDoneDateList);
    }

    @Override
    public void showDoneSum(int sum) {
        this.sum = sum;
        tvSum.setText(String.format(getResources().getString(R.string.done_sum), sum));
    }

    @Override
    public void addDoneDate(Calendar calendar) {
        mDoneDateList.add(calendar);
        calendarView.update();
        sum++;
        tvSum.setText(String.format(getResources().getString(R.string.done_sum), sum));
    }

    @OnClick({R.id.tv_month_day, R.id.fl_current})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_month_day:
                calendarView.showYearSelectLayout(mYear);
                tvLunar.setVisibility(View.GONE);
                tvYear.setVisibility(View.GONE);
                tvMonthDay.setText(String.valueOf(mYear));
                break;
            case R.id.fl_current:
                calendarView.scrollToCurrent();
                break;
        }
    }
}
