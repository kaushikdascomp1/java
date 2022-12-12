package DesignPatterns.template;

public class Cricket extends Game {

    @Override
    public void initialize() {
        System.out.println("Cricket Game Initialized. All 11 Players are ready");
    }

    @Override
    public void startGame() {
        System.out.println("Cricket Game started. Enjoy the game");
    }

    @Override
    public void endGame() {
        System.out.println("Cricket Game ended::  ");
    }
}
