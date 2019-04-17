import java.util.ArrayList;

public class Stock {

    class Interval{
        int buy,sell;
    }
    public static void main(String args[]){
        int arr[] = new int[]{100, 180, 260, 310, 40, 535, 695};
        Stock stck=new Stock();
        stck.findDays(arr);
    }

    public void findDays(int arr[]){
        int n = arr.length;
        int i=0;
        int count=0;
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        while(i<n-1){
            while(i<n-1 && arr[i]>arr[i+1])
                i++;
            if(i==n-1)

                break;
            Interval interval = new Interval();
            interval.buy=i++;
            while(i<n && arr[i]>=arr[i-1])
                i++;
            interval.sell=i-1;
            intervals.add(interval);
            count++;
        }
        if(count==0)
            System.out.println("No Such days found");
        else
            for(int j=0;j<count;j++){
                System.out.println("Buy at:"+ intervals.get(j).buy +  "Sell at:" +intervals.get(j).sell);
            }
    }
}
