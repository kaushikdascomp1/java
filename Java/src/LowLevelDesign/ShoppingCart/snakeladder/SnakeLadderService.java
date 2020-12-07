package Java.src.LowLevelDesign.ShoppingCart.snakeladder;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class SnakeLadderService {

    public SnakeLadderBoard snakeLadderBoard;
    Queue<Player> playerQueue;
    int winningPosition;

    boolean hasGameCompleteted;

    int intialPlayers;

    public SnakeLadderService(int maximumSize){
        this.winningPosition = maximumSize;
        snakeLadderBoard = new SnakeLadderBoard(maximumSize);
        hasGameCompleteted = false;
        playerQueue = new LinkedList<Player>();
    }

    public int movePlayerPieces(Player player, int newPosition){
        int oldPosition = snakeLadderBoard.getPlayerPieces().get(player.getId());

        int newPos = oldPosition+newPosition;
        //check if any snake or ladder is present in the new position
        if(newPos > snakeLadderBoard.getSize()){
            newPos = oldPosition;
        }else {
            newPos = movePlayerWithSnakeLadder(newPos);
        }

        snakeLadderBoard.getPlayerPieces().put(player.getId(),newPos);
        return newPos;
    }

    public int movePlayerWithSnakeLadder(int oldPosition){
        //Check for any snakes or ladders in the new position
        int newPos = oldPosition;
        Optional<Snakes> snakeStarting = snakeLadderBoard.getSnakes().stream().filter(snakes -> snakes.getStart() == oldPosition).findFirst();
        if(snakeStarting.isPresent()){
            newPos = snakeStarting.get().getEnd();
        }

        Optional<Ladder> ladderFirst = snakeLadderBoard.getLadders().stream().filter(ladder -> ladder.getStart() == oldPosition).findFirst();
        if(ladderFirst.isPresent()){
            newPos = ladderFirst.get().getEnd();
        }

        return newPos;

    }

    public boolean hasPlayerWon(Player player){
        int currentPos = snakeLadderBoard.getPlayerPieces().get(player.getId());
        if(currentPos == winningPosition){
            System.out.println("Player with ID:: "+player.getId()+"  And Name:: "+player.getName() +"  HAs won");
            return true;
        }

        return false;
    }

    public boolean isGameCompleted(){
        int currentPlayers = snakeLadderBoard.getPlayerPieces().size();
        if( currentPlayers < intialPlayers)
            return true;

        return false;
    }

    public void setPlayersQueue(List<Player> players){
        this.intialPlayers = players.size();
        for(Player player:players){
            playerQueue.add(player);
            snakeLadderBoard.getPlayerPieces().put(player.getId(),0);
        }

    }

    public void startGame(){
        while (!isGameCompleted()){
            int dicerRoll = snakeLadderBoard.getDiceRoll();
            Player player = playerQueue.poll();
            movePlayerPieces(player,dicerRoll);
            if(hasPlayerWon(player)){
                System.out.println("Player won:: "+player.getName());
                this.snakeLadderBoard.getPlayerPieces().remove(player.getId());
            }else {
                playerQueue.add(player);
            }
        }
    }



}
