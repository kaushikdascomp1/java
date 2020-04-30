package Java.src.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {
        printItem("ABC");
        printItem(12);
        printItem(24.34d);
        printItem(true);
        printItem(24l);
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        System.out.println(sum(ints));

        //List of Doubles
        List<Double> doubles = Arrays.asList(1.5d,2d,3d);
        System.out.println(sum(doubles));
    }

    public static <T> void printItem(T item){
        System.out.println(item);
    }

    //This is Producer gets value PE Producer Extends, It will just accept values, You cannot add values in this

    private static Number sum(List<? extends Number> numbers){
        double s=0;
        for (Number number:numbers)
            s +=number.doubleValue();
        return s;
    }
        //covariance is producer
    void testCoVariance(List<? extends Shape> list){
       // list.add(new Circle()); --throwing error, just uncomment it
        //list.add(new Square());
        list.get(0);
    }

    void testContraVariance(List<? super Shape> list){
        list.add(new Circle());
        list.add(new Square());
      // Shape shape = list.get(0);  //getting error because of type mismatch
        Object object = list.get(0);
    }

    //contravariance consumer super example
        //T... represents T[]
    public static <T> boolean addAll(Collection<? super T> collection, T... elements){

        return false;
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max)>0)
            max = y;
        if(z.compareTo(max)>0)
            max = z;
        return max;
    }


}
