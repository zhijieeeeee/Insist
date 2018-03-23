package com.zhijieeeeee.insist.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public abstract class AbstractBaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(getContentViewLayoutId(), container, false);
        ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        before(savedInstanceState);
        attachAndInject();
        initView();
        initData();
        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
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
