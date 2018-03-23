package com.zhijieeeeee.insist.base.activity;

import com.zhijieeeeee.insist.app.InsistApp;
import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.base.view.BaseView;
import com.zhijieeeeee.insist.dagger.component.DaggerFragmentComponent;
import com.zhijieeeeee.insist.dagger.component.FragmentComponent;
import com.zhijieeeeee.insist.dagger.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public abstract class BaseFragment<T extends BasePresenter> extends AbstractBaseFragment implements BaseView {

    @Inject
    public T mPresenter;

    @Override
    public void attachAndInject() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView(this);
        }
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(InsistApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    /**
     * 注入所需依赖对象，调用getActivityComponent().inject(this);
     */
    protected abstract void initInject();
}
