package com.example.fordlabs.recyclertest.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.fordlabs.recyclertest.BR;
import com.example.fordlabs.recyclertest.adapter.CustomAdapter;
import com.example.fordlabs.recyclertest.model.LinkedApps;
import com.example.fordlabs.recyclertest.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NameViewModel extends BaseObservable implements LifecycleObserver {


    ArrayList<NameItemViewModel>namesList = new ArrayList<NameItemViewModel>();

    @Inject
    public NameViewModel() {
    }

    CustomAdapter adapter = new CustomAdapter();



    @Bindable
    public CustomAdapter getAdapter() {
        return adapter;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

        User usr1 = new User();
        NameItemViewModel nameItemViewModel = new NameItemViewModel();
        ArrayList<LinkedApps> appsList = new ArrayList<>();
        LinkedApps  linkedApps = new LinkedApps();
        linkedApps.setLinkedappName("WHATS APP");
        linkedApps.setLinkedAppId("001");
        appsList.add(linkedApps);

        LinkedApps  linkedApps2  = new LinkedApps();
        linkedApps2.setLinkedappName("VIBER");
        linkedApps2.setLinkedAppId("002");

        appsList.add(linkedApps2);

        nameItemViewModel.setName("USER1");
        nameItemViewModel.setAvailableApps(getAvailableApps(appsList));

        namesList.add(nameItemViewModel);


        User usr2 = new User();
        NameItemViewModel nameItemViewModel2 = new NameItemViewModel();
        ArrayList<LinkedApps> appsList2 = new ArrayList<>();
        LinkedApps  linkedApps3 = new LinkedApps();
        linkedApps3.setLinkedappName("WHATS APP");
        linkedApps3.setLinkedAppId("001");
        appsList2.add(linkedApps3);

        LinkedApps  linkedApps4  = new LinkedApps();
        linkedApps4.setLinkedappName("VIBER");
        linkedApps4.setLinkedAppId("002");

        appsList2.add(linkedApps4);

        nameItemViewModel2.setName("USER2");
        nameItemViewModel2.setAvailableApps(getAvailableApps(appsList2));

        namesList.add(nameItemViewModel2);


        adapter.setNamesList(namesList);

        notifyPropertyChanged(BR._all);


    }

    private String getAvailableApps(ArrayList<LinkedApps> appsList) {
        String appsNames="";
        for(LinkedApps linkedAppsObj: appsList){
            appsNames = appsNames +" "+linkedAppsObj.getLinkedappName();
        }
        appsList.toArray().toString();
        return appsNames;
    }


}
