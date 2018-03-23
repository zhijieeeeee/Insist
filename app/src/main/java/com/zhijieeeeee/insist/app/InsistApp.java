package com.zhijieeeeee.insist.app;

import android.app.Application;
import android.support.v4.BuildConfig;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.zhijieeeeee.insist.R;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public class InsistApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
        initLogger();
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
}
