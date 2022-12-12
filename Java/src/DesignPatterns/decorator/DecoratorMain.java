package DesignPatterns.decorator;

public class DecoratorMain {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        //This prints a normal circle without the red border
        circle.draw();
        //This prints a circle with red border
        redCircle.draw();
    }
}
