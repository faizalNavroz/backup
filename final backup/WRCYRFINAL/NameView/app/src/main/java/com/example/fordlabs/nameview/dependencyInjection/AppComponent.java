package com.example.fordlabs.nameview.dependencyInjection;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,NetworkApiModule.class,ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<NameApplication>{

}
