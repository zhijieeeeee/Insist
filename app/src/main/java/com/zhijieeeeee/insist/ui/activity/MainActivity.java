package com.zhijieeeeee.insist.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.activity.BaseActivity;
import com.zhijieeeeee.insist.contract.MainContract;
import com.zhijieeeeee.insist.presenter.MainPresenter;
import com.zhijieeeeee.insist.ui.fragment.BookFragment;
import com.zhijieeeeee.insist.ui.fragment.PlanFragment;
import com.zhijieeeeee.insist.ui.fragment.SettingFragment;
import com.zhijieeeeee.insist.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tv_plan)
    TextView tvPlan;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.tv_book)
    TextView tvBook;
    private PlanFragment planFragment;
    private SettingFragment settingFragment;
    private BookFragment bookFragment;
    private List<Fragment> fragmentList;
    private List<TextView> textViewList;

    private long exitTime = 0;

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void before(Bundle savedInstanceState) {
        fragmentList = new ArrayList<>();
        textViewList = new ArrayList<>();
    }

    @Override
    public void initView() {
        planFragment = new PlanFragment();
        settingFragment = new SettingFragment();
        bookFragment = new BookFragment();
        fragmentList.add(planFragment);
        fragmentList.add(bookFragment);
        fragmentList.add(settingFragment);
        textViewList.add(tvPlan);
        textViewList.add(tvBook);
        textViewList.add(tvSetting);

        switchFragment(0);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @OnClick({R.id.tv_plan, R.id.tv_setting, R.id.tv_book})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_plan:
                switchFragment(0);
                break;
            case R.id.tv_book:
                switchFragment(1);
                break;
            case R.id.tv_setting:
                switchFragment(2);
                break;
        }
    }

    private void switchFragment(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragmentList) {
            ft.hide(fragment);
        }
        for (TextView textView : textViewList) {
            textView.setSelected(false);
        }
        textViewList.get(index).setSelected(true);
        Fragment targetFragment = fragmentList.get(index);
        if (!targetFragment.isAdded()) {
            ft.add(R.id.fl_container, targetFragment);
        }
        ft.show(targetFragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtil.show("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }
}
