import java.util.ArrayList;

//Scanner sc = new Scanner(System.in);
//		int t=sc.nextInt();
//		for(int h=0;h<t;h++){
//		    int n=sc.nextInt();
//		    int k=sc.nextInt();
//		    GFG gfg = new GFG(n);
//		    for(int j=0;j<n;j++){
//		        gfg.insertKey(sc.nextInt());
//		    }
//		    gfg.minHeap();
//		    for(int i=0; i<k;i++ ){
//            System.out.println(gfg.extractMin());
//            }
//		}
//
public class MaxHeap {
    public int Heap[] = null;
    int currSize;
    int size;

    public MaxHeap(int size){
        this.currSize = 0;
        this.size=size;
        this.Heap = new int[size+2];
        //Heap[0] = Integer.MAX_VALUE;
    }

    public  int parent(int i){
        return i-1/2;
    }

    public int left(int i){
        return 2*i+1;
    }

    public int right(int i){
        return 2*i+2;
    }

    public static void main (String[] args) {
        System.out.println("Test");
        MaxHeap heap = new MaxHeap(7);
        heap.insertKey(12);
        heap.insertKey(3);
        heap.insertKey(4);
        heap.insertKey(2);
        heap.insertKey(13);
        heap.minHeap();
        heap.print();

        for(int i=0; i<2;i++ ){
            System.out.println("Popped:"+ heap.extractMin());
        }

    }

    public void print()
    {
        for (int i = 0; i <= size/2 ; i++) {
            System.out.print(" PARENT : " + Heap[i-1/2] + " LEFT CHILD : " +
                    Heap[2 * i+1] + " RIGHT CHILD :" + Heap[2 * i + 2]);
            System.out.println();
        }
    }

    public void insertKey(int k){
        if(currSize == size){
            System.out.println("Overflow");
        }
        currSize ++;
        Heap[currSize-1] = k;
        int current = currSize;
        while(Heap[parent(current)]< Heap[current]){
            swap(parent(current),current);
            current=parent(current);
        }
    }
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 0; pos--) {
            minHeapify(pos);
        }
    }

    public int extractMin(){
        int root =0;
        if(size<=0 ){
            return 0;
        }else if(size == 1){
            root = Heap[0];
            size--;
            return root;
        }else {
            root = Heap[0];
            Heap[0] = Heap[size-1];
            size--;
            minHeapify(0);
            return root;
        }
    }

    public void swap(int a, int b){
        int temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }

    public void minHeapify(int i){
        int largest =i;
        int left=left(i);
        int right = right(i);
        if(left<size && Heap[left]>Heap[i]){
            largest = left;
        }
        if(right<size && Heap[right]>Heap[largest] ){
            largest = right;
        }
        if(i!=largest){
            swap(i, largest);
            minHeapify(largest);
        }
    }
}
