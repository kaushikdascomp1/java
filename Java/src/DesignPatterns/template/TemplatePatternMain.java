package Java.src.DesignPatterns.template;

public class TemplatePatternMain {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();
    }

}
