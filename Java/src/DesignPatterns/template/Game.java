package Java.src.DesignPatterns.template;

public abstract class Game {

    public abstract void initialize();
    public abstract void startGame();
    public abstract void endGame();

    //Creating the template
    public void play(){
        //First initialize the game
        initialize();

        //start the game
        startGame();

        //end the game
        endGame();
    }
}
