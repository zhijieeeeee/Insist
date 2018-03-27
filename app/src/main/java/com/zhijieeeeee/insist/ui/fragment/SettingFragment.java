package com.zhijieeeeee.insist.ui.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.base.fragment.BaseFragment;
import com.zhijieeeeee.insist.contract.SettingContract;
import com.zhijieeeeee.insist.presenter.SettingPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashin on 2018/3/24.
 */

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingContract.View {

    @BindView(R.id.animation_view)
    LottieAnimationView animationView;
    @BindView(R.id.btn_modify_week)
    Button btnModifyWeek;
    @BindView(R.id.btn_modify_year)
    Button btnModifyYear;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.setting_fragment;
    }

    @Override
    public void before(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animationView.setVisibility(View.GONE);
                animationView.cancelAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean registerEventBus() {
        return false;
    }

    @OnClick({R.id.btn_modify_week, R.id.btn_modify_year})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_modify_week:
                break;
            case R.id.btn_modify_year:
                break;
        }
    }
}
