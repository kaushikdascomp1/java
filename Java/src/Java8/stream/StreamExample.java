package Java.src.Java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,4,6,12,20);
        boolean ans = list.stream().anyMatch(n -> (n*(n+1)/4 == 5));
        System.out.println(ans);

       List<String> arrList = new ArrayList<String>();
        arrList.add("Red");
        arrList.add("Green");
        arrList.add("Blue");
        arrList.add("Red");
        arrList.add("Green");
        arrList.add("Red");
        arrList.add("Black");

        Map<String,Long> collect = arrList.stream().collect(groupingBy(Function.identity(),counting()));
        System.out.println(collect);

        //If we want it in Integer form
        Map<String,Integer> collectIntegers = arrList.stream().collect(groupingBy(Function.identity(),summingInt(e->2)));
        System.out.println(collectIntegers);

        //minimum in a stream
        Integer minValue =  list.stream().min(Integer::compare).get();
        System.out.println("Minimum Value: "+minValue);

        String[] array = { "Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz" };
        String minString = Arrays.stream(array).min(String::compareTo).get();
        System.out.println(minString);

        //min Length for String
        // To find the minimum string length values
        Optional<String> minStringLength = Arrays.stream(array).min((str1, str2)->Character.compare(str1.charAt(str1.length()-1),
                str2.charAt(str2.length()-1)));
        System.out.println("Minimum String length Values: " + minStringLength.get());

        //Reduce Operation
        int sum = list.stream().reduce(0,Integer::sum);
        System.out.println("Sum of all integers: " + sum);

        // Sum using Reduce operation--Similar to the above method
        int multiply = list.stream().reduce(0,(a,b)->a*b);
        System.out.println("Multiplication of all integers in array: "+ multiply);

        //Find minimum using reduce min
        int min = list.stream().reduce(Integer.MAX_VALUE,Integer::min);
        System.out.println("Minimum of all Integers:  "+ min);

        Optional<Integer> minVal = list.stream().reduce(Integer::min);
        System.out.println("Calculation of minimum value using Optional:  "+minVal.get());
        //Instead of using Integer.MaxValue which specifies as the default value
        // It can also be specified without the default value but the return type should be optional(In cases where the stream is empty)

        Optional<Integer> sum1 = list.stream().reduce((a,b)->a+b);
        System.out.println("Sum of Integers without using default value:  " + sum1.get());

        //Numeric Ranges using range and rangeClosed
        IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(n->n%2==0);
        System.out.println("Total 50 numbers is returned:  " +evenNumbers.count()); // Using this as terminal operation

        IntStream evenNumbers1 = IntStream.range(1,100).filter(n->n%2==0);
        System.out.println("Total 49 numbers returned as both ends are exclusive: "+ evenNumbers1.count());

        //Finding Pythagorean Triplets
        Stream<int[]> pytha = IntStream.rangeClosed(1,100).boxed().flatMap(a->
                IntStream.rangeClosed(a,100).filter(b->Math.sqrt(a*a+b*b)%1==0).mapToObj(b->new int[]
                        {a,b,(int)Math.sqrt(a*a+b*b)}));
       pytha.limit(5).forEach(a-> System.out.println(a[0] + " "+ a[1]+ " "+ a[2]));


    }



}
