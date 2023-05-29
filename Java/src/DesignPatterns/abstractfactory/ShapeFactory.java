package DesignPatterns.abstractfactory;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shape) {
        if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
}
