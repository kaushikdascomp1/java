package com.interview.java.designpatterns.snakeandladder;

import java.util.*;

public class SnakeLadderBoard {

    private int size;
    public List<Snake> snakes;
    public List<Ladder> ladders;

    Map<Integer, Integer> playerPieces;

    public SnakeLadderBoard(int size){
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
        this.size = size;
    }

    public int diceRoll(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<Integer, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<Integer, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
