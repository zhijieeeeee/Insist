package com.zhijieeeeee.insist.dagger.module;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.zhijieeeeee.insist.dagger.scope.ActivityScope;
import com.zhijieeeeee.insist.dagger.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangzhijie on 2018/3/23.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    FragmentActivity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @FragmentScope
    ProgressDialog provideProgressDialog(FragmentActivity activity) {
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setMessage("请稍等");
        return dialog;
    }
}
