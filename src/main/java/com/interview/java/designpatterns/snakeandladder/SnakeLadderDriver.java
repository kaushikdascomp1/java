package com.interview.java.designpatterns.snakeandladder;

import java.util.Arrays;
import java.util.List;

public class SnakeLadderDriver {

    public static void main(String[] args) {
        List<Ladder> ladderList = Arrays.asList(new Ladder(2,21), new Ladder(4,7), new Ladder(10,25), new Ladder(19,28));
        List<Snake> snakeList = Arrays.asList(new Snake(26,0), new Snake(20,8), new Snake(16,3), new Snake(18,6));

        SnakeLadderService snakeLadderService = new SnakeLadderService(100);
        Players players1 = new Players(1,"Kaushik");
        Players players2 = new Players(2,"Shivam");
        List<Players> playersList = Arrays.asList(players1,players2);

        snakeLadderService.setPlayersQueue(playersList);
        snakeLadderService.setLadders(ladderList);
        snakeLadderService.setSnakes(snakeList);

        snakeLadderService.startGame();

    }
}
