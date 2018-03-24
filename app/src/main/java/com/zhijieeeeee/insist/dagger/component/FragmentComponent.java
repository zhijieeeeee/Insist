package com.zhijieeeeee.insist.dagger.component;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.zhijieeeeee.insist.dagger.module.FragmentModule;
import com.zhijieeeeee.insist.dagger.scope.FragmentScope;
import com.zhijieeeeee.insist.ui.fragment.PlanDayFragment;
import com.zhijieeeeee.insist.ui.fragment.PlanFragment;
import com.zhijieeeeee.insist.ui.fragment.SettingFragment;

import dagger.Component;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    FragmentActivity getActivity();

    void inject(PlanFragment planFragment);

    void inject(SettingFragment settingFragment);

    void inject(PlanDayFragment planDayFragment);
}
