package DesignPatterns.abstractfactory;

public class RoundedAbstractFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shape) {
        if(shape.equalsIgnoreCase("ROUNDED_RECTANGLE")){
            return new RoundedRectangle();
        } else if (shape.equalsIgnoreCase("ROUNDED_SQUARE")) {
            return new RoundedSquare();
        }

        return null;
    }
}
