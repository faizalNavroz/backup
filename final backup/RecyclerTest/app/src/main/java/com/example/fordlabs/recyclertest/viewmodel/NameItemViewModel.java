package com.example.fordlabs.recyclertest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import javax.inject.Inject;

public class NameItemViewModel extends BaseObservable {

    private String name ;

    private String availableApps;

    public void setAvailableApps(String availableApps) {
        this.availableApps = availableApps;
    }

    @Bindable

    public String getAvailableApps() {
        return availableApps;
    }

    ObservableField<String>observableName = new ObservableField<String>();

    ObservableField<String>observableAppNames = new ObservableField<String>();

    @Inject
    public NameItemViewModel() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableField<String> getObservableName() {
        return observableName;
    }

    public void setObservableName(ObservableField<String> observableName) {
        this.observableName = observableName;
    }




}
