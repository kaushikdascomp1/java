package src.com.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310,
                40, 535, 695 };
        int n = price.length;
        System.out.println(maxProfit(price,0,n-1));

        stockBuySell(price,0,n);

        //https://www.geeksforgeeks.org/stock-buy-sell/

    }
    //Simple solution where you can buy and sell only once
    //Keep a track of the minimum

    public static int findMaxProfitStock(int[] stock){
        if(stock == null || stock.length == 0)
            return 0;
        int result = 0;
        int min = stock[0];

        for(int i=1;i<stock.length;i++){
            result = Math.max(result,stock[i]-min);
            min = Math.min(min,stock[i]);
        }

        return result;
    }

    public static int maxProfit(int[] stock, int start, int end){
        if (end <= start)
            return 0;
        int max_profit = Integer.MIN_VALUE;

        for(int i=start;i<end;i++){
            for(int j=i+1;j<=end;j++){
                if (stock[j] > stock[i]){
                    int curr_profit = stock[j] - stock[i] + maxProfit(stock, start, i-1)+maxProfit(stock, j+1, end);
                    max_profit = Math.max(curr_profit,max_profit);
                }

            }
        }

        return max_profit;
    }
    //Complexity f the above solution is O(2^n) as we are using two recursion stack and two loops

    //This problem can also be solved using local mnima and local maxima

    static class Interval{
        int buy;
        int sell;
        public Interval(){

        }
    }

    private static List<Interval> stockBuySell(int[] stock, int start, int end){
        int i = 0;
        List<Interval> solutionList = new ArrayList<>();
        while(i<end-1){
            while ((i<end-1) && stock[i+1]<=stock[i])
                i++;

            if(i == end-1)
                break;
            Interval interval = new Interval();
            interval.buy = i++;

            while ((i<end-1) && stock[i+1]>=stock[i])
                i++;
            interval.sell = i++;

            solutionList.add(interval);

        }

        for(Interval interval:solutionList)
            System.out.println("Buy at:  "+interval.buy+ "  And Sell at:: "+interval.sell);

        return solutionList;
    }

}
