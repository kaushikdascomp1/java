package com.interview.java.designpatterns.cricinfodesign;

import java.util.List;

public class Innings {

    public static int BALLS_IN_AN_OVER = 6;
    int oversRemaining;
    int ballsRemaining;
    Player batsman;
    Player runnerBy;
    MatchFormat matchFormat;
    int currentInnings;
    Team currentTeam;

    boolean hasInningsEnded = false;

    public Innings(int currentInnings, Team currentTeam, MatchFormat matchFormat){
        this.currentInnings = currentInnings;
        this.currentTeam = currentTeam;
        this.matchFormat = matchFormat;
        oversRemaining = matchFormat.getNumberOfOvers();
        ballsRemaining = BALLS_IN_AN_OVER;
    }

    private void startNewOver(){
        if(oversRemaining != 0){
            //Fresh Over
            ballsRemaining = BALLS_IN_AN_OVER;
            rotateStrike();
        }else
            hasInningsEnded = true;

    }

    public void rotateStrike(){
        Player temp = batsman;
        batsman = runnerBy;
        runnerBy = temp;
    }

    public void startInnings(){
        List<Player> openers = currentTeam.getOpeners();
        this.batsman = openers.get(0);
        this.runnerBy = openers.get(1);
        batsman.setStatus(PlayerInningStatus.BATTING);
        runnerBy.setStatus(PlayerInningStatus.BATTING);
    }

    public void addBowl(BowlTypes bowlTypes){
        if(hasInningsEnded)
            return;
        if(ballsRemaining == 0)
            startNewOver();
        updateTeam(bowlTypes);
        ballsRemaining -=bowlTypes.getBowlConsumed();
    }

    private void updateTeam(BowlTypes bowlTypes){
        switch (bowlTypes){
            case NO_BALL:
                currentTeam.incrementScore(BowlTypes.NO_BALL.getRunsGiven());
                break;
            case WIDE_BALL:
                currentTeam.incrementScore(BowlTypes.WIDE_BALL.getRunsGiven());
            case SINGLE:
                currentTeam.incrementScore(BowlTypes.SINGLE.getRunsGiven());
                batsman.incrementRuns(BowlTypes.SINGLE.getRunsGiven());
                batsman.incrementBallsFaced();
                rotateStrike();
                break;
            case DOUBLE:
                currentTeam.incrementScore(BowlTypes.DOUBLE.getRunsGiven());
                batsman.incrementRuns(BowlTypes.DOUBLE.getRunsGiven());
                batsman.incrementBallsFaced();
                break;

            case TRIPLE:
                currentTeam.incrementScore(BowlTypes.TRIPLE.getRunsGiven());
                batsman.incrementRuns(BowlTypes.TRIPLE.getRunsGiven());
                batsman.incrementBallsFaced();
                rotateStrike();
                break;
            case FOUR:
                currentTeam.incrementScore(BowlTypes.FOUR.getRunsGiven());
                batsman.incrementRuns(BowlTypes.FOUR.getRunsGiven());
                batsman.incrementBallsFaced();
                batsman.incrementFours();
                break;

            case SIX:
                currentTeam.incrementScore(BowlTypes.SIX.getRunsGiven());
                batsman.incrementRuns(BowlTypes.SIX.getRunsGiven());
                batsman.incrementBallsFaced();
                batsman.incrementSixes();
                break;

            case WICKETS:
                currentTeam.incrementScore(BowlTypes.WICKETS.getRunsGiven());
                currentTeam.incrementWickets();
                batsman.incrementBallsFaced();
                batsman.setStatus(PlayerInningStatus.OUT);
                batsman = currentTeam.getNextPlayer();
                break;
        }

    }

    public boolean isHasInningsEnded(){
        return hasInningsEnded;
    }

}
