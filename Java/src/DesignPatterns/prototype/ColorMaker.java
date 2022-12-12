package DesignPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class ColorMaker {

    public static Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("blue",new BlueColor("blue"));
        colorMap.put("black", new BlackColor("black"));
    }

    public static Color getColor(String colorName){
        return (Color) colorMap.get(colorName).clone();
    }
}
