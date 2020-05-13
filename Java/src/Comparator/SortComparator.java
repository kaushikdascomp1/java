package Java.src.Comparator;

import java.util.Comparator;
import java.util.Map;

public class SortComparator implements Comparator<Integer> {

    private final Map<Integer, Integer> map;

    public SortComparator(Map<Integer, Integer> map){
        this.map=map;
    }

    @Override
    public int compare(Integer k1, Integer k2){
       int frequency = map.get(k1).compareTo(map.get(k2));
       int value = k1.compareTo(k2);

       if(frequency == 0){
           return value;
       }else{
           return frequency;
       }
    }
}
