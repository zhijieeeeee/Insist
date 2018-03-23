package com.zhijieeeeee.insist.app;

import android.app.Application;
import android.support.v4.BuildConfig;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.umeng.commonsdk.UMConfigure;
import com.zhijieeeeee.insist.R;
import com.zhijieeeeee.insist.dagger.component.AppComponent;
import com.zhijieeeeee.insist.dagger.component.DaggerAppComponent;
import com.zhijieeeeee.insist.dagger.module.AppModule;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class InsistApp extends Application {

    public static InsistApp mInstance;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initLeakCanary();
        initLogger();
        initUmeng();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                    tag(getString(R.string.app_name)).build()));
        }
    }

    private void initUmeng() {
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mInstance))
                    .build();
        }
        return appComponent;
    }
}
