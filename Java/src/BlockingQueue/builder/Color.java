package BlockingQueue.builder;

public abstract class Color implements Cloneable{

    protected String colorName;

    public abstract void addColor();

    @Override
    protected Object clone() {
        Object clonedObj = null;
        try {
            clonedObj = super.clone();
        }catch (CloneNotSupportedException exception){
            exception.printStackTrace();
        }

        return clonedObj;
    }
}
