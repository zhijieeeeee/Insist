package com.zhijieeeeee.insist.dagger.component;

import android.app.Activity;

import com.zhijieeeeee.insist.dagger.module.FragmentModule;
import com.zhijieeeeee.insist.dagger.scope.FragmentScope;
import com.zhijieeeeee.insist.ui.fragment.PlanFragment;

import dagger.Component;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(PlanFragment planFragment);

}
