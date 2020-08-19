package com.interview.java.designpatterns.cricinfodesign;

import lombok.Data;

@Data
public class Player {

    private int playerNo;
    private String playerName;
    private int runsScored;
    private int ballsFaced;
    private int fours;
    private int sixes;
    private int wicketsTaken;
    PlayerInningStatus status = PlayerInningStatus.DID_NOT_BAT;

    public Player(int playerNo, String playerName){
        this.playerNo = playerNo;
        this.playerName = playerName;
    }

    public void incrementRuns(int num){
        runsScored+=num;
    }

    public void incrementFours(){
        fours++;
    }

    public void incrementSixes(){
        sixes++;
    }

    public void incrementBallsFaced(){
        ballsFaced++;
    }

    public void incrementWicketsTaken(){
        wicketsTaken++;
    }
}
