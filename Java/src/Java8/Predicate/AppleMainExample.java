package Java8.Predicate;

import Java.src.Java8.Models.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppleMainExample {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green",120.0), new Apple("red", 110.0), new Apple("brown", 150.0), new Apple("green", 160.0),
                new Apple("red", 122.0));
        //Filter Apples with weight > 150
       // ApplePredicates.filterApples(apples,ApplePredicates.isWeightAbove150()).forEach(System.out::println);

        //Filter apples with color green
        //ApplePredicates.filterApples(apples,ApplePredicates.isColorGreen()).forEach(System.out::println);

        Predicate<Apple> andPredicate = ApplePredicates.isColorGreen().and(ApplePredicates.isWeightAbove150());
        //apples.stream().filter(andPredicate).forEach(System.out::println);

        //Negate example
        Predicate<Apple> negatePredicate = ApplePredicates.isColorGreen().negate();
        //apples.stream().filter(negatePredicate).forEach(System.out::println);

        //Negate Example with weight > 150
        Predicate<Apple> negatePredicateWithWeightGreaterThan150 = ApplePredicates.isWeightAbove150().negate();
        apples.stream().filter(negatePredicateWithWeightGreaterThan150).forEach(System.out::println);

        //Example of Test
        Apple testApple = new Apple("green",120.0);
        System.out.println(ApplePredicates.isColorGreen().test(testApple));

        System.out.println(apples.stream().filter(ApplePredicates.isColorGreen()).count());

        //Parallel stream example
        List<Integer> lists = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            lists.add(i);
        }

        Stream<Integer> parallelStream = lists.parallelStream();
        Integer[] intArray = parallelStream.filter(x->x%2 == 0).toArray(Integer[]::new);
        System.out.println(intArray);

        //Use of Intstream predicate to find prime numbers


    }

    public boolean isPrime(int number){
        return IntStream.range(2,number).noneMatch(
                index->number % index == 0
        );
    }

    public boolean isPrimePredicate(int number){
        IntPredicate intPredicate = index -> number % index == 0;

        return IntStream.range(2,number).noneMatch(intPredicate);

    }
}
