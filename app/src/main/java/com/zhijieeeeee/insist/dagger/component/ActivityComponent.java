package com.zhijieeeeee.insist.dagger.component;

import android.app.Activity;
import android.app.ProgressDialog;

import com.zhijieeeeee.insist.ui.activity.MainActivity;
import com.zhijieeeeee.insist.dagger.module.ActivityModule;
import com.zhijieeeeee.insist.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    ProgressDialog getProgressDialog();

    void inject(MainActivity mainActivity);
}
