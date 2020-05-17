package com.interview.java.designpatterns.snakeandladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class SnakeLadderService {

    public SnakeLadderBoard snakeLadderBoard;
    public Queue<Player> playerQueue;
    public int initialPlayers;

    public boolean isGameCompleted;
    public int winningPosition ;

    public SnakeLadderService(int size){
        this.snakeLadderBoard = new SnakeLadderBoard(size);
        playerQueue = new LinkedList<>();
        winningPosition = snakeLadderBoard.getSize();
    }

    public void setLadders(List<Ladder> ladderList){
        snakeLadderBoard.setLadders(ladderList);
    }

    public void setSnakes(List<Snake> snakesList){
        snakeLadderBoard.setSnakes(snakesList);
    }

    public int movePlayerWithSnakeLadder(int previousPos){
        //check for test cases where after the snake end or the ladder end there could be another snake or ladder
        int newPosition = previousPos;

        /*for (Snake snake:snakeLadderBoard.getSnakes()){
            if(snake.getStart() == previousPos){
                System.out.println("Snake Bite at:: " + previousPos);
                newPosition = snake.getEnd();
            }
        }*/
        Optional<Snake> snakeEnd = snakeLadderBoard.getSnakes().stream().filter(snake -> snake.getStart() == previousPos).findFirst();
        if(snakeEnd.isPresent()){
            newPosition = snakeEnd.get().getEnd();
        }

        for (Ladder ladder:snakeLadderBoard.getLadders()){
            if(ladder.getStart() == previousPos){
                System.out.println("Found Ladder at:: " + previousPos);
                newPosition = ladder.getEnd();
            }
        }

        return newPosition;

    }

    public int moveplayer(Player player, int newPosition){
        int oldPos = snakeLadderBoard.getPlayerPieces().get(player.getId());
        int newPos = oldPos + newPosition;


        if(newPos > snakeLadderBoard.getSize()){
            newPos = oldPos;
        }else {
            //check if in new position snake or ladder is present
            newPos = movePlayerWithSnakeLadder(newPos);
        }

        snakeLadderBoard.getPlayerPieces().put(player.getId(),newPos);
        return newPos;
    }

    public boolean hasPlayerWon(Player player){
        int playerPos = snakeLadderBoard.getPlayerPieces().get(player.getId());
        if(playerPos == winningPosition)
            return true;
        else
            return false;
    }

    public void setPlayerQueue(List<Player> playerList){
            this.initialPlayers = playerList.size();
            for (Player player:playerList){
                playerQueue.add(player);
                this.snakeLadderBoard.getPlayerPieces().put(player.getId(),0);
            }
    }

    public boolean isGameCompleted(){
        int currentPlayers = snakeLadderBoard.getPlayerPieces().size();
        return currentPlayers < initialPlayers;
    }

    public void startGame(){
        while (!isGameCompleted()){
            int diceRoll = snakeLadderBoard.diceRoll();
            Player player = playerQueue.poll();
            moveplayer(player,diceRoll);
            if(hasPlayerWon(player)){
                System.out.println("Yeah!! Player won::" + player.getName());
                this.snakeLadderBoard.getPlayerPieces().remove(player.getId());
            }else {
                playerQueue.add(player);
            }
        }
    }
}
