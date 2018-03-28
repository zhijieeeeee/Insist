package com.zhijieeeeee.insist.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public abstract class AbstractBaseFragment extends Fragment {

    private Unbinder unBinder;
    //懒加载实现-----
    private boolean isFirstVisible = true;
    private boolean isFragmentVisible = false;
    private View rootView;
    //懒加载实现-----

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(getContentViewLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        attachAndInject();
        before(savedInstanceState);
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

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //fragment在调用show，hide的时候不会走生命周期，但是会回调这个方法
    }

    //懒加载实现---------------
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //如果setUserVisibleHint()在rootView创建前调用时，那么
        //就等到rootView创建完后才回调onFragmentVisibleChange(true)
        //保证onFragmentVisibleChange()的回调发生在rootView创建完成之后，以便支持ui操作
        if (rootView == null) {
            rootView = view;
            if (getUserVisibleHint()) {
                if (isFirstVisible) {//第一次可见
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //注意：setUserVisibleHint() 有可能在 onCreateView() 创建 view 之前调用，所以在onViewCreated也进行判断
        if (rootView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {//第一次可见
            onFragmentFirstVisible();
            isFirstVisible = false;
        }
        if (isVisibleToUser) {//不可见->可见
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {//可见->不可见
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
        }
    }

    /**
     * Fragment第一次可见
     */
    public void onFragmentFirstVisible() {}


    /**
     * Fragment可见状态改变
     */
    public void onFragmentVisibleChange(boolean visible) {}

    //懒加载实现---------------
}
