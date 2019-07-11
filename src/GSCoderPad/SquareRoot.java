package src.GSCoderPad;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(findRoot(100));
    }

    public static double findRoot(double x){
        double sqRoot = 0;
        double currEstimate = x/2;

        while(x>=0.0){
            sqRoot=currEstimate-(currEstimate*currEstimate - x)/(2*currEstimate);
            double diff = Math.abs(currEstimate-sqRoot);
            if(diff< 0.001){
                return sqRoot;
            }else{
                currEstimate=sqRoot;
            }
        }
        return x;
    }
}
