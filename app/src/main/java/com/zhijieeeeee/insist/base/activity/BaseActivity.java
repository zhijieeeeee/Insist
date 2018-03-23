package com.zhijieeeeee.insist.base.activity;

import com.zhijieeeeee.insist.app.InsistApp;
import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.base.view.BaseView;
import com.zhijieeeeee.insist.dagger.component.ActivityComponent;
import com.zhijieeeeee.insist.dagger.component.DaggerActivityComponent;
import com.zhijieeeeee.insist.dagger.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AbstractBaseActivity implements BaseView {

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
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView(this);
        }
    }

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(InsistApp.getAppComponent())
                .activityModule(new ActivityModule(mActivity))
                .build();
    }

    /**
     * 注入所需依赖对象，调用getActivityComponent().inject(this);
     */
    protected abstract void initInject();
}
