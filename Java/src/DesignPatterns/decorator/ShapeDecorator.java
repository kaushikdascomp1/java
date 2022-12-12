package DesignPatterns.decorator;

public abstract class ShapeDecorator implements Shape {

    Shape shapeDecorator;

    public ShapeDecorator(Shape shapeDecorator){
        this.shapeDecorator = shapeDecorator;
    }

    @Override
    public void draw() {
        shapeDecorator.draw();
    }
}
