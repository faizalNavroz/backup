package com.example.fordlabs.recyclertest.dependencyInjection;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,NetworkModule.class,ActivityBuilderModule.class})
public interface NameAppComponent extends AndroidInjector<NameApp> {

}
