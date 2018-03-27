package com.zhijieeeeee.insist.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhijieeeeee.insist.app.Constants;
import com.zhijieeeeee.insist.app.InsistApp;
import com.zhijieeeeee.insist.util.DataManager;
import com.zhijieeeeee.insist.util.SpManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@Module
public class AppModule {

    private InsistApp app;

    public AppModule(InsistApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    InsistApp provideInsistApp() {
        return app;
    }

    @Provides
    @Singleton
    SpManager provideSpManager() {
        return new SpManager();
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new DataManager();
    }
}
