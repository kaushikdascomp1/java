package DesignPatterns.decorator;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }

    @Override
    public void draw() {
        shapeDecorator.draw();
        setRedBorder();
    }

    public void setRedBorder(){
        System.out.println("Setting Red Border");
    }
}
