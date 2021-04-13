package com.interview.java.designpatterns.snakeandladder;

import java.util.Arrays;
import java.util.List;

public class SnakeLadderDriver {

    public static void main(String[] args) {
        List<Ladder> ladderList = Arrays.asList(new Ladder(2,21), new Ladder(4,7), new Ladder(10,25), new Ladder(19,28));
        List<Snake> snakeList = Arrays.asList(new Snake(26,0), new Snake(20,8), new Snake(16,3), new Snake(18,6));

        SnakeLadderService snakeLadderService = new SnakeLadderService(100);
        Player player1 = new Player(1,"Kaushik");
        Player player2 = new Player(2,"Shivam");
        List<Player> playerList = Arrays.asList(player1, player2);

        snakeLadderService.setPlayerQueue(playerList);
        snakeLadderService.setLadders(ladderList);
        snakeLadderService.setSnakes(snakeList);

        snakeLadderService.startGame();

    }
}
