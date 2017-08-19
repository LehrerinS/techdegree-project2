package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Team {

    private String mTeamName;
    private String mCoachName;
    private Set<Player> mCollectionOfPlayers;

    public Set<Player> getmCollectionOfPlayers() {
        return mCollectionOfPlayers;
    }

    public void setmCollectionOfPlayers(Set<Player> mCollectionOfPlayers) {
        this.mCollectionOfPlayers = mCollectionOfPlayers;
    }

    public Team(String teamName, String coachName, Set<Player> collectionOfPlayers) {
        mTeamName = teamName;
        mCoachName = coachName;
        mCollectionOfPlayers = collectionOfPlayers;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public String getCoachName() {
        return mCoachName;
    }

    public void setmTeamName(String mTeamName) {
        this.mTeamName = mTeamName;
    }

    public void setmCoachName(String mCoachName) {
        this.mCoachName = mCoachName;
    }

    public Set<Player> addPlayerToTeam(Player player){
        mCollectionOfPlayers.add(player);
        return mCollectionOfPlayers;
    }

    public Set<Player> removePlayerFromTeam(Player player){
        mCollectionOfPlayers.remove(player);
        return mCollectionOfPlayers;
    }

    @Override
    public String toString(){
        return String.format("Team has %s name and %s coach %n", getTeamName(), getCoachName());
    }

}