package Java.src.DesignPatterns.prototype;

public class BlackColor extends Color {

    public BlackColor(String colorName){
        this.colorName = colorName;
    }

    @Override
    public void addColor() {
        System.out.println("Black Color Added:: ");
    }
}
