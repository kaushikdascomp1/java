package com.interview.java.designpatterns.cricinfodesign;

import java.util.ArrayList;
import java.util.List;

public class Team {

    String name;
    String description;
    List<Player> playerList;
    int score;
    int wickets;
    int nextPlayerNo;
    MatchFormat matchFormat;

    public Team(String name, String description, MatchFormat format){
        this.name = name;
        this.description = description;
        this.matchFormat = format;
        playerList = new ArrayList<>();
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void removePlayer(Player player){
        playerList.remove(player);
    }

    public List<Player> getOpeners(){
        List<Player> openers = new ArrayList<>();
        openers.add(playerList.get(0));
        openers.add(playerList.get(1));

        nextPlayerNo = 2;
        return openers;
    }

    public void incrementScore(int num){
        score+=num;
    }

    public void incrementWickets(){
        wickets++;
    }

    public Player getNextPlayer(){
        if(nextPlayerNo >= playerList.size())
            return null;
        Player p = playerList.get(nextPlayerNo);
        nextPlayerNo++;
        return p;
    }

}
