package com.example.fordlabs.recyclertest.dependencyInjection;

import com.example.fordlabs.recyclertest.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity providesMainActivity();
}
