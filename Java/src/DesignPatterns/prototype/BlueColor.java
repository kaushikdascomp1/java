package Java.src.DesignPatterns.prototype;

public class BlueColor extends Color {

    public BlueColor(String colorName){
        this.colorName = colorName;
    }

    @Override
    public void addColor() {
        System.out.println("Blue Color Added:: ");
    }
}
