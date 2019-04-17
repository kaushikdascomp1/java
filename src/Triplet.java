public class Triplet {
    /**
     *
     * find one triplet such that the indexes are in the increasing order
     * and also the values
     * @param args
     */


    public static void main(String args[]){
        int arr[] = new int[]{6,2,3,4,1,8};
        findTriplets(arr);
    }

    public static void findTriplets(int arr[]){
        int max1=0; int index1=0;
        int max2=0; int index2=0;
        int max3=0; int index3=0;

        for(int i=0;i<arr.length;i++){
            if(max1<arr[i] && max2<=max1 && max3<=max2){
                max1=arr[i];
                index1=i;
            }else if(max2<arr[i] && max3<=max2){
                max2=arr[i];
                index2=i;
            }else if(max3<arr[i]){
                max3=arr[i];
                index3=i;
            }
        }

        System.out.println("Values are:"+max1 +" : "+max2+" : " +max3);
    }
}
