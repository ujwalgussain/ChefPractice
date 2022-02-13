package Dynamic_Programming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToConnectNRopes {
    //PS: https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1#
    long minCost(long arr[], int n)
    {
        // your code here
        if(n==0)
            return 0;
        if(n==1)
            return 0;
        if(n==2)
            return arr[0] + arr[1];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Arrays.stream(arr).forEach(x->minHeap.offer(x));
        long minCost = minHeap.poll() + minHeap.poll();
        minHeap.offer(minCost);
        while(minHeap.size()>=2){
            long sum = (minHeap.poll()+minHeap.poll());
            minCost += sum;
            minHeap.offer(sum);
        }
        return minCost;
    }
}
