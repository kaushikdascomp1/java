package DesignPatterns.template;

public class Football extends Game {

    @Override
    public void initialize() {
        System.out.println("Footbal game initialized:: All players are ready");
    }

    @Override
    public void startGame() {
        System.out.println("Football game started, Enjoy the game");
    }

    @Override
    public void endGame() {
        System.out.println("Football game ended::: ");
    }
}
