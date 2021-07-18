package PracticeProblems.ArrayProblems;

import Heaps.MinHeap;

import java.util.Arrays;

public class FindKLargestElementsFromFile {
    /*There are various solution to this problem:
        1. Use bubble sort k times O(n*k)
        2. Use minheap:
            create min of size k with first k elements
            for each ele if minheap min ele < arr[i] just remove min and put new entry O(k + (n-k)Logk)
        3. Sort the Entries
    * */
    public static void main(String[] args) {
        int arr[] = {1,2,14,5,47,25,18,19,3,7};
        MinHeap minHeap = new MinHeap();
        int k=3;
        minHeap.buildHeap(Arrays.copyOfRange(arr,0,k));
        minHeap.display();
        for (int i = k; i < arr.length; i++) {
            //Repeat n-k times O(n-k)
            if(minHeap.getMin()<arr[i])
            {
                /*minHeap.extractMin(); // O(log k)
                minHeap.insert(arr[i]);// O(log k)*/
                minHeap.replaceMin(arr[i]); // O(log k)
            }
        }
        System.out.println("K max Elements - ");
        minHeap.display();
        // O(n-k) + O(n-k(log k))
    }
}
