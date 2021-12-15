package a_practiceproblems.ArrayProblems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    /*
    * Ref : https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
    * Logic :
    *   Naive : A simple solution is to create an output array and and one by one copy all arrays to it and sort. This approach takes O(N Logn N) time.
        Efficient : An efficient solution is to use heap data structure. The time complexity of heap based solution is O(N Log k).
            Insert Oth element from all arrays in min heap.
            Poll min element from heap and insert next element from the same array in the heap.

    * */
    void merge(int[][] arr) {

        class Element {
            int array_no;
            int idx;

            public Element(int array_no, int idx) {
                this.array_no = array_no;
                this.idx = idx;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        //min heap
        PriorityQueue<Element> queue = new PriorityQueue<>((x, y) -> arr[x.array_no][x.idx] - arr[y.array_no][y.idx]);

        for (int i = 0; i < arr.length; i++)
            queue.offer(new Element(i, 0));

        while (!queue.isEmpty()) {
            Element polled = queue.poll();
            if (polled.idx + 1 < arr[polled.array_no].length) {
                queue.offer(new Element(polled.array_no, polled.idx + 1));
            }
            result.add(arr[polled.array_no][polled.idx]);
        }
        System.out.println(result);
    }
}
