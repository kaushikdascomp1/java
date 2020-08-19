package com.interview.java.designpatterns.cricinfodesign;

public class ScoreBoard {

    Team A;
    Team B;
    Team currentPlayingTeam;
    int inningsNumber;
    MatchFormat matchFormat;
    Innings currentInnings;

    public static class ScoreBoardBuilder{
        Team A;
        Team B;
        MatchFormat matchFormat;

        public ScoreBoardBuilder(){

        }

        public ScoreBoardBuilder firstTeam(Team a){
            A = a;
            return this;
        }

        public ScoreBoardBuilder secondTeam(Team b){
            B = b;
            return this;
        }

        public ScoreBoardBuilder matchFormat(MatchFormat format){
            matchFormat = format;
            return this;
        }

        public ScoreBoard build(){
            return new ScoreBoard(this);
        }

    }

    public ScoreBoard(ScoreBoardBuilder builder){
        this.A = builder.A;
        this.B = builder.B;
        this.matchFormat = builder.matchFormat;
    }

    public String getMatchResult(){
        if (A.score > B.score)
            return "Team A won by "+(A.score-B.score)+" runs";
        else
            return "Team B won by  "+(B.playerList.size() - B.wickets)+ " wickets";
    }

    public void startNewInnings(){
        inningsNumber++;

        if(inningsNumber % 2 == 1)
            currentPlayingTeam = A;
        else
            currentPlayingTeam = B;

        currentInnings = new Innings(inningsNumber,currentPlayingTeam,matchFormat);
        currentInnings.startInnings();

    }


    public void addBowl(BowlTypes bowlTypes){
        if(currentInnings.hasInningsEnded)
            return;
        currentInnings.addBowl(bowlTypes);
    }
}
