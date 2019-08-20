package com.example.fordlabs.nameview.dependencyInjection;

import com.example.fordlabs.nameview.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity providesMainActivity();
}
