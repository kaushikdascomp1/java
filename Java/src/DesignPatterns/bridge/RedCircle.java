package DesignPatterns.bridge;

public class RedCircle implements DrawApi{

    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing Red Circle of radious" + radius);
    }
}
