package DesignPatterns.prototype;

public class ColorMakerMain {

    public static void main(String[] args) {
        ColorMaker.getColor("blue").addColor();
        ColorMaker.getColor("black").addColor();
        ColorMaker.getColor("blue").addColor();

    }
}
