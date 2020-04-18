package src.com.interview.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     * Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
     */

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int distanceFromOrigin(){
            return x*x+y*y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> kthClosestPoints = kthClosestPoints(points, 2);
        kthClosestPoints.stream().forEach(System.out::println);
    }

    public static List<Point> kthClosestPoints(Point[] points, int k){
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((n1,n2)->n2.distanceFromOrigin() - n1.distanceFromOrigin());

        for(int i=0;i<k;i++){
            maxHeap.add(points[i]);
        }

        for(int i=k;i<points.length;i++){
            if(points[i].distanceFromOrigin()<maxHeap.peek().distanceFromOrigin()){
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        return new ArrayList<>(maxHeap);

    }
}
