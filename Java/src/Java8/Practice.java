package Java8;

import Java.src.Java8.B;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {
        List<Integer> number=Arrays.asList(2,3,4,5);
        List<Integer> square = number.stream().map(x->(x*x)).collect(Collectors.toList());
        System.out.println(square);

        List<String> strings = Arrays.asList("reflection","collection","stream");
        List<String> stringsFil = strings.stream().filter(x->x.startsWith("r")).collect(Collectors.toList());
        System.out.println(stringsFil);

        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings1.stream().filter(x->!x.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        Random rand = new Random();
        rand.ints().limit(10).forEach(System.out::println);

        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
        System.out.println(namesOriginalList);
        Stream<String> flatMap = namesOriginalList.flatMap(str->str.stream());
        System.out.println(flatMap);

        //match
        boolean match = number.stream().anyMatch(i->i==4);
        System.out.println(match);
        Optional<String> str = strings.stream().filter(x->x.startsWith("r")).findFirst();
        System.out.println(str.isPresent());



        //Functionl Interface
        //You can provide the implementation of FI using lambda expressions
        B inter = ()-> System.out.println("Hello");
        inter.m1();
    }
}
