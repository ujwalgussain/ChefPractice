package a_practiceproblems.ArrayProblems.binarySearch;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {

    private boolean isEven = true;
    //first Half elems
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //secondhalf half sorted elems
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double findMedian() {
        double median =  isEven ? (minHeap.peek() + maxHeap.peek()) / 2D : maxHeap.peek();
        System.out.println("Median - " + median);
        return median;
    }

    public void addNum(int num) {
        System.out.println("Inserting num = "+num);
        if (isEven) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        System.out.printf("max-%s, min-%s\n", maxHeap, minHeap);
        isEven = !isEven;
    }

    /*
    Example : stream = [3,2,1,5,6,7]
    Inserting num = 3
    max-[3], min-[] -> [3]
    Median - 3.0

    Inserting num = 2
    max-[2], min-[3] -> [2,3]
    Median - 2.5

    Inserting num = 1
    max-[2, 1], min-[3] -> [1,2,3]
    Median - 2.0

    Inserting num = 5
    max-[2, 1], min-[3, 5] -> [1,2,3,5]
    Median - 2.5

    Inserting num = 6
    max-[3, 1, 2], min-[5, 6] -> [1,2,3,5,6]
    Median - 3.0

    Inserting num = 7
    max-[3, 1, 2], min-[5, 6, 7] -> [1,2,3,5,6,7]
    Median - 4.0
     */

}
