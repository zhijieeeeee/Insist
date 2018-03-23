package com.zhijieeeeee.insist.dagger.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

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
    Activity provideActivity() {
        return fragment.getActivity();
    }

}
