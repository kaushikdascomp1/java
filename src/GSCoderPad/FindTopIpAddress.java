package src.GSCoderPad;

import java.util.HashMap;
import java.util.Map;

public class FindTopIpAddress {

    public static void main(String[] args) {
        String lines[] = new String[]{
                "10.0.0.1 - frank[10/Dec/2000:12:34] \"GET",
                "10.0.0.1 - frank[10/Dec/2000: 11:54] \"GET",
                "10.0.0.2 - nancy[10/Dec/2000: 11:54] \"GET"
        };
        System.out.println(findTopIpAddress(lines));
    }

    public static String findTopIpAddress(String[] lines){
        if(null == lines || lines.length==0)
            return "";

        Map<String, Integer> mapList = new HashMap<String, Integer>();

        for(String line : lines){
            String ipadd = line.split(" ")[0];
            if(mapList.containsKey(ipadd)){
                mapList.put(ipadd,mapList.get(ipadd)+1);
            }else{
                mapList.put(ipadd,1);
            }
        }

        int max = 0;
        String str = "";
        for(Map.Entry<String,Integer> getValues:mapList.entrySet()){
            if(getValues.getValue()>max){
                max = getValues.getValue();
                str = getValues.getKey();
            }
        }
        return str;
    }
}
