package com.zhijieeeeee.insist.dagger.module;

import com.zhijieeeeee.insist.app.InsistApp;
import com.zhijieeeeee.insist.util.DataManager;

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
    DataManager provideDataManager() {
        return new DataManager();
    }
}
