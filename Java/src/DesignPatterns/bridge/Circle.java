package DesignPatterns.bridge;

public class Circle extends Shape{

    private int x, y, radius;
    public Circle(int x, int y, int radius, DrawApi drawApi){
        super(drawApi);
        this.x = x;
        this.y = y;
        this.drawApi = drawApi;
    }

    @Override
    public void drawCircle(int x, int y, int radius) {

    }

    @Override
    public void draw() {
        drawApi.drawCircle(x, y, radius);
    }


}
