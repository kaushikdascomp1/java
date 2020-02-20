package src.GSCoderPad;

import java.util.*;

public class BestAverageGrade {

    public static void main(String[] args) {
        String tc1[][] = {{"Bobby","87"},
                          {"Charles","100"},
                        {"Eric","64"},
                        {"Charles","22"}
        };
        System.out.println(bestAvgGrade(tc1));
    }

    public static double calculateAvg(List<String> list){
        Double sum = list.stream().mapToDouble(i->Double.valueOf(i)).sum();
       /* double sum = 0;
        for(String str:list){
            sum += Double.valueOf(str);
        }*/
        return Math.floor(sum/list.size());
    }

    public static int bestAvgGrade(String[][] scores){
        Map<String, List<String>> mapList = new HashMap<String, List<String>>();
        Arrays.stream(scores).forEach((item) -> {
            List<String> scoreList = mapList.get(item[0]);

           if(null == scoreList || scoreList.isEmpty()){
               scoreList = new ArrayList<String>();
           }
            scoreList.add(item[1]);
            mapList.put(item[0],scoreList);
        });

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
