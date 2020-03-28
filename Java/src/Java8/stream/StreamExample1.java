package Java.src.Java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {

    public static void main(String[] args) {
        String[] words = {"Hello","World"};
        // Find all distinct characters from the words ["H", "e", "l", "o",
        //"W", "r", "d"].

         List<String[]> arrStream = Arrays.stream(words).map(x->x.split("")).distinct().collect(Collectors.toList());
        System.out.println(arrStream.get(0));

        //As this is List of String[] we need to use flatmap

        Arrays.stream(words).map(word->word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        //Given a list of numbers, how would you return a list of the square of each number? For
        //example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25]

        int[] numbers = {1,2,3,4,5};

         Arrays.stream(numbers).map(x->x*x).forEach(System.out::println);

         List<Integer> numberList = Arrays.asList(1,2,3,4,5);
         List<Integer> sqaureList = numberList.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(sqaureList);

        //Given two lists of numbers, how would you return all pairs of numbers? For example, given a
        //list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
        //simplicity, you can represent a pair as an array with two elements.

        List<Integer> numList1 = Arrays.asList(1,2,3);
        List<Integer> numList2 = Arrays.asList(3,4);

        List<int[]> pairs = numList1.stream().flatMap(i->numList2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());
        pairs.stream().map(Arrays::toString).forEach(System.out::println);

        //From the above filter out those pairs which are not divisible by 3

        List<int[]> pairSumDivisible = numList1.stream().flatMap(i->numList2.stream().filter(j->(i+j)%3==0).map(j->new int[]{i,j})).collect(Collectors.toList());

        pairSumDivisible.stream().map(Arrays::toString).forEach(System.out::println);

        //find squares divisible by 3
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);

        Optional<Integer> numbersDivisibleBy3 = numbers1.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
        numbersDivisibleBy3.stream().forEach(System.out::println);

        // To find the sum of all integers in the list reduce can be used
        Integer sumInteger = numbers1.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sumInteger);


    }


}
