package BlockingQueue.builder;

import java.util.HashMap;
import java.util.Map;

public class ColorMaker {

    public static Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("blue", new BlueColor());
        colorMap.put("black", new BlackColor());
    }

    public static Object getColor(String colorName){
        return colorMap.get(colorName).clone();
    }
}
