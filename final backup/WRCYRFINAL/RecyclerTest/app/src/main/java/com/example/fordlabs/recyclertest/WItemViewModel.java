package com.example.fordlabs.recyclertest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

public class WItemViewModel extends BaseObservable {

    private String name ;

    ObservableField<String>observableName = new ObservableField<String>();

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
