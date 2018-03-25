package com.zhijieeeeee.insist.dagger.component;

import com.zhijieeeeee.insist.app.InsistApp;
import com.zhijieeeeee.insist.dagger.module.AppModule;
import com.zhijieeeeee.insist.util.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    InsistApp getApp();

    DataManager getDataManager();
}
