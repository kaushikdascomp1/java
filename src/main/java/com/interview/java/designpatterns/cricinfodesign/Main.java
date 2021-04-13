package com.interview.java.designpatterns.cricinfodesign;

public class Main {

    public static void main(String[] args) {

        Team A = new Team("India","Indian Team", MatchFormat.ODI);
        A.addPlayer(new Player(1,"Sehwag"));
        A.addPlayer(new Player(2,"Sachin"));
        A.addPlayer(new Player(3,"Kohli"));
        A.addPlayer(new Player(4,"Dravid"));
        A.addPlayer(new Player(5,"Yuvraj"));

        //Prepare second Team
        Team B = new Team("Australia","Australian Team", MatchFormat.ODI);
        B.addPlayer(new Player(1,"Gilchrist"));
        B.addPlayer(new Player(2,"Hayden"));
        B.addPlayer(new Player(3,"Ponting"));
        B.addPlayer(new Player(4,"Smith"));
        B.addPlayer(new Player(5,"Clarke"));

        ScoreBoard scoreBoard = new ScoreBoard.ScoreBoardBuilder()
                .firstTeam(A).secondTeam(B).matchFormat(MatchFormat.ODI).build();
        scoreBoard.startNewInnings();
        scoreBoard.addBowl(BowlTypes.FOUR);
        scoreBoard.addBowl(BowlTypes.SINGLE);
        scoreBoard.addBowl(BowlTypes.DOUBLE);
        scoreBoard.addBowl(BowlTypes.TRIPLE);
        scoreBoard.addBowl(BowlTypes.WIDE_BALL);
        scoreBoard.addBowl(BowlTypes.NO_BALL);
        scoreBoard.addBowl(BowlTypes.WICKETS);// Wicket
        scoreBoard.addBowl(BowlTypes.WICKETS);// Wicket
        scoreBoard.addBowl(BowlTypes.FOUR);
        scoreBoard.addBowl(BowlTypes.SINGLE);
        scoreBoard.addBowl(BowlTypes.DOUBLE);
        scoreBoard.addBowl(BowlTypes.TRIPLE);
        scoreBoard.addBowl(BowlTypes.WIDE_BALL);
        scoreBoard.addBowl(BowlTypes.NO_BALL);
        scoreBoard.addBowl(BowlTypes.WICKETS);// wicket


        // Simulating Second Innings
        scoreBoard.startNewInnings();
        scoreBoard.addBowl(BowlTypes.FOUR);
        scoreBoard.addBowl(BowlTypes.WICKETS); // wicket

        scoreBoard.addBowl(BowlTypes.SINGLE);
        scoreBoard.addBowl(BowlTypes.DOUBLE);
        scoreBoard.addBowl(BowlTypes.TRIPLE);
        scoreBoard.addBowl(BowlTypes.WICKETS); // wicket

        scoreBoard.addBowl(BowlTypes.WIDE_BALL);
        scoreBoard.addBowl(BowlTypes.NO_BALL);
        scoreBoard.addBowl(BowlTypes.WICKETS); // wicket

        scoreBoard.addBowl(BowlTypes.FOUR);
        scoreBoard.addBowl(BowlTypes.SINGLE);

        System.out.println(scoreBoard.getMatchResult());

    }
}
