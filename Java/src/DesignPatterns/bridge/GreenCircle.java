package DesignPatterns.bridge;

public class GreenCircle implements DrawApi{

    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing Green circle with radius:: "+radius);
    }
}
