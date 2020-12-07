package Java.src.LowLevelDesign.ShoppingCart.snakeladder;

import java.util.*;

public class SnakeLadderBoard {

    List<Snakes> snakes;
    List<Ladder> ladders;
    int size;

    Map<Integer, Integer> playerPieces;

    public SnakeLadderBoard(int size){
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }

    public int getDiceRoll(){
        Random random = new Random();
       return random.nextInt(6)+1;
    }

    public List<Snakes> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snakes> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<Integer, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }

}
