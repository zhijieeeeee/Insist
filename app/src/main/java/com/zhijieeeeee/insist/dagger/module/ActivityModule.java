package com.zhijieeeeee.insist.dagger.module;

import android.app.Activity;

import com.zhijieeeeee.insist.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }
}
