package com.example.fordlabs.recyclertest.model;

import java.util.List;

public class User {

    public List<LinkedApps> getLinkedApps() {
        return linkedApps;
    }

    public void setLinkedApps(List<LinkedApps> linkedApps) {
        this.linkedApps = linkedApps;
    }

    private List<LinkedApps> linkedApps;


}
