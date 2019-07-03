package src.GSCoderPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAverageGrade {

    public static void main(String[] args) {
        String[][] tc1 = {{"Bobby","87"},
                          {"Charles","100"},
                        {"Eric","64"},
                        {"Charles","22"}
        };
        System.out.println(bestAvgGrade(tc1));
    }

    public static double calculateAvg(List<String> list){
        double sum = 0;
        for(String str:list){
            sum += Double.valueOf(str);
        }
        return Math.floor(sum/list.size());
    }

    public static int bestAvgGrade(String[][] scores){
        Map<String, List<String>> mapList = new HashMap<String, List<String>>();
        for(int i=0;i<scores.length;i++){
            String arr[] = scores[i];
           List<String> scoreList = mapList.get(arr[0]);
           if(null == scoreList || scoreList.isEmpty()){
               scoreList = new ArrayList<String>();
           }
           scoreList.add(arr[1]);
           mapList.put(arr[0],scoreList);
        }
        double maxAvg = 0;
        for(List<String> val:mapList.values()){
            double avg = calculateAvg(val);
            if(avg>maxAvg){
                maxAvg = avg;
            }
        }
        return (int) maxAvg;
    }
}
