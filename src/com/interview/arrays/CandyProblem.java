package arrays;

public class CandyProblem {

    /*
            This problem is similar to Rain water traping
          There are N children standing in a line. Each child is assigned a rating value. You are
            giving candies to these children subjected to the following requirements:
                1. Each child must have at least one candy.
                2. Children with a higher rating get more candies than their neighbors.
            What is the minimum candies you must give?
            https://leetcode.com/problems/candy/
            Eg [1,0,2] are the rating values
            Algo: Traverse from left to right and if rating is higher assign one more candy than the previous one
            Again cross check by traversing from right to left
            Candy Values [1,1,2] after left to right
            Candy values [2,1,2] after right to left traversal
     */

    public static void main(String[] args) {
            int[] ratings = {1,0,2};
        System.out.println(findMinimumCandy(ratings));
    }

    public static int findMinimumCandy(int[] ratings) {
        if (ratings.length <= 0)
            return 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //Traversing from left to right for ascending order values
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }

        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                candies[j] = Math.max(candies[j], candies[j+1]+1);
            }
        }

        int totalCandies = 0;
        for(int candie: candies){
            totalCandies +=candie;
        }

        return totalCandies;


    }

}
