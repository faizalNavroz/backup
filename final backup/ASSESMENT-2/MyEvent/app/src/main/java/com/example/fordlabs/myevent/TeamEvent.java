package com.example.fordlabs.myevent;

public class TeamEvent {

    public int teamId;

    public String teamName;

    public  int teamPosition;

    public TeamEvent(int teamId, String teamName, int teamPosition) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamPosition = teamPosition;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(int teamPosition) {
        this.teamPosition = teamPosition;
    }
}
