package com.zhijieeeeee.insist.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhijieeeeee.insist.util.ActivityManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public abstract class AbstractBaseActivity extends AppCompatActivity {

    private Unbinder unBinder;
    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        mActivity = this;
        unBinder = ButterKnife.bind(this);
        before(savedInstanceState);
        attachAndInject();
        initView();
        initData();
        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }
        ActivityManager.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        ActivityManager.removeActivity(this);
        unBinder.unbind();
    }

    /**
     * 设置布局,必须返回layout的id
     */
    public abstract int getContentViewLayoutId();

    /**
     * 设置布局之前的逻辑
     *
     * @param savedInstanceState 被销毁之前保存的数据
     */
    public abstract void before(Bundle savedInstanceState);

    /**
     * 关联presenter和进行依赖注入
     */
    public abstract void attachAndInject();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 是否注册EventBus
     */
    public abstract boolean registerEventBus();
}
