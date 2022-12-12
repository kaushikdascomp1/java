package DesignPatterns.prototype;

public abstract class Color implements Cloneable{

    protected String colorName;

    public abstract void addColor();

    @Override
    protected Object clone() {
        Object clonedObj = null;
        try{
            clonedObj = super.clone();
        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
        return clonedObj;
    }
}
