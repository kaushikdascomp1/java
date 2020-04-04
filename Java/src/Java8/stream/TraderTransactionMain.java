package Java.src.Java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

public class TraderTransactionMain {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1.
        //Find all transactions in the year 2011 and sort them by value (small to high).

        Stream<Transaction> sortedTransactions = transactions.stream().filter(x -> x.getYear() == 2011).sorted(comparing(Transaction::getValue));
        sortedTransactions.forEach(System.out::println);

        //2.
        //What are all the unique cities where the traders work?
        Stream<String> distinctCities = transactions.stream().map(x -> x.getTrader().getCity()).distinct();
        distinctCities.forEach(System.out::println);


        //Alternatively in lieu of distinct collectors.toSet can also be used
        Set<String> collectDistinctCities = transactions.stream().map(x -> x.getTrader().getCity()).collect(Collectors.toSet());
        collectDistinctCities.forEach(System.out::println);

        //3.
        //Find all traders from Cambridge and sort them by name
        List<Trader> cambridgeSorted = transactions.stream().map(x -> x.getTrader()).filter(x -> x.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).collect(Collectors.toList());
        cambridgeSorted.forEach(System.out::println);

        //4.
        //Return a string of all traders’ names sorted alphabetically
        String traderNames =  transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(Collectors.joining());

        //Alternatively this can be done as
        String traderNamString = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+n2);

        //5.
        //Are any traders based in Milan?
        boolean isAnyTraderInMilan = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        //6.
        //Print all transactions’ values from the traders living in Cambridge.
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).forEach(e->{
            e.getValue();
        });

        //7.
        //What’s the highest value of all the transactions?
        Integer highestTransactionValue = transactions.stream().map(transaction -> transaction.getValue()).max(Integer::compare).get();
        System.out.println("Highest Transaction value is: " + highestTransactionValue);

        //8.
        // Find the transaction with the smallest value.
        Integer lowestTransactionValue = transactions.stream().map(transaction -> transaction.getValue()).min(Integer::compare).get();
        System.out.println("Lowest Transaction Value is: " + lowestTransactionValue);


    }
}
