package ChefProblems.src;

import java.util.Arrays;

public class MinHeapImpl {
    int heap[];
    MinHeapImpl(int data[])
    {
        createMinHeap(data);
    }
    void createMinHeap(int data[])
    {
        heap = Arrays.copyOf(data,data.length);
        for(int i=((data.length-1)/2);i>=0;i--)
        {
            minHeapify(i);
        }
    }
    void minHeapify(int i)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left<heap.length && heap[left] < heap[i])
        {
            largest = left;
        }
        if (right<heap.length && heap[right]<heap[largest])
        {
            largest = right;
        }
        System.out.printf("i = %s left= %s right = %s largest = %s\n",i,left,right,largest);
        if (largest !=i )
        {
            System.out.printf("Swap %s and %s\n",i,largest);
            System.out.printf("Before Swap %s\n",Arrays.toString(heap));
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            System.out.printf("After Swap %s\n",Arrays.toString(heap));
            minHeapify(largest);
        }
    }
    int extractMin()
    {
        if(heap.length==0)
            return -1;
        int min = heap[0];
        heap[0]=heap[heap.length-1];
        heap = Arrays.copyOf(heap,heap.length-1);
        minHeapify(0);
        System.out.println("After Extraction "+Arrays.toString(heap));
        return min;
    }
    static public void main(String args[])
    {
        MinHeapImpl m = new MinHeapImpl(new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(m.heap));
      //  String s = m.extractMin() + " " + m.extractMin()+ " " + m.extractMin()+ " " + m.extractMin()+ " " + m.extractMin();
      //   System.out.println(s);



    }
}
