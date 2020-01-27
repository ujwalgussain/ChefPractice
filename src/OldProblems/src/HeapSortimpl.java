package OldProblems.src;

import java.util.Arrays;

public class HeapSortimpl {

    static void maxheapify(int[] a,int i,int heapsize)
    {
        int left = 2*i+1;
        int right = left+1;
        int largest = left<heapsize && a[left]>a[i]?left:i;
        largest = right<heapsize && a[right]>a[largest]?right:largest;
        if(largest !=i)
        {
            int temp =a[largest];
            a[largest]=a[i];
            a[i]=temp;
            maxheapify(a,largest,heapsize);
        }
    }
    static void createHeap(int a[])
    {
        for(int i = (a.length-1)/2;i>=0;i--)
        {
            maxheapify(a,i,a.length);
        }
    }
    static void heapSort(int a[])
    {
        createHeap(a);
        int heapsize=a.length;
        for(int i=a.length-1; i>=1;i--)
        {
            int temp = a[0];
            a[0]=a[i];
            a[i]=temp;
            maxheapify(a,0,--heapsize);
        }
    }
    static public void main(String args[])
    {
        int[] a =new int[]{3,2,12,0,4,5,6};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
