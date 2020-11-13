package src.com.interview.matrix;

import java.util.Stack;

public class MaximalAreaRectangleMatrixof1 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        System.out.println(findMaxArea(matrix));
    }

    public static int findMaxArea(int[][] matrix){
        if(null == matrix || matrix.length == 0)
            return -1;

        int row = matrix.length;
        int col = matrix[0].length;

        int[] height = new int[col];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0)
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            maxArea = Math.max(maxArea, findArea(height));

        }
        return maxArea;
    }


    //This is Maximum area in Histogram
    //Difference between MAH and maximum water to be contained both are different as in MAH we consider the bar heights and not the empty spaces
    public static int findArea(int[] height){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i=1;i<height.length;i++){
            int curr = height[stack.peek()];
            if(stack.isEmpty() || curr >= height[stack.peek()]){
                stack.add(i);
            }else {
                while (!stack.isEmpty() && curr < height[stack.peek()]){
                    int temp = height[stack.pop()];
                    if(stack.isEmpty()){
                        max = Math.max(max,temp*i);
                    }else {
                        max = Math.max(max,temp*(i-stack.peek()-1));
                    }
                }
                stack.add(i);
            }
        }

        //This could be condition when all elements are greater than curr and kept on adding elements in the stack
        if (!stack.isEmpty()){
            while (!stack.isEmpty()){
                int i = height.length;
                int temp = height[stack.pop()];
                if(stack.isEmpty()){
                    max = Math.max(max,temp*i);
                }else {
                    max = Math.max(max,temp*(i-stack.peek()-1));
                }
            }
        }

        return max;
    }
}
