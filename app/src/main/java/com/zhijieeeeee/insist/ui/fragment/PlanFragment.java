package com.zhijieeeeee.insist.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.contract.PlanContract;
import com.zhijieeeeee.insist.presenter.PlanPresenter;
import com.zhijieeeeee.insist.util.ToastUtil;

import butterknife.BindView;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class PlanFragment extends BaseFragment<PlanPresenter> implements PlanContract.View {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private String[] titles = new String[]{"每日计划", "每周计划", "2018年"};

    @Override
    public void showData(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.plan_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        VpAdapter adapter = new VpAdapter(mActivity.getSupportFragmentManager());
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    private class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new PlanDayFragment();
            } else if (position == 1) {
                return new PlanWeekFragment();
            } else {
                return new PlanYearFragment();
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

}
