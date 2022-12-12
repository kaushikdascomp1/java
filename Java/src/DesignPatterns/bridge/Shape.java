package DesignPatterns.bridge;

public abstract class Shape implements DrawApi{

    public DrawApi drawApi;

    public Shape(DrawApi api){
        this.drawApi = api;
    }
    public abstract void draw();
}
