package a_practiceproblems.heaps;

public class MaxHeap {
    int heap[] = new int[1000];
    int heap_size=0;
    void copyData(int arr[])
    {
        heap_size=arr.length;
        for (int i = 0; i < heap_size; i++) {
            heap[i]=arr[i];
        }
    }
    public void buildHeap(int[] arr)
    {
        copyData(arr);
        for (int i = (heap_size/2); i>=0; i--) {
            maxHeapify(i);
        }
    }
    void maxHeapify(int i)
    {
        int left = (i<<1)+1;
        int right= (i<<1)+2;
        int largest = i;
        if(left<heap_size && heap[left]>heap[largest])
        {
            largest=left;
        }
        if(right<heap_size && heap[right]>heap[largest])
        {
            largest=right;
        }
        if(largest != i )
        {
            swap(i,largest);
            maxHeapify(largest);
        }
    }
    public int extractMax()
    {
        if(heap_size==0)
        {
            System.out.println("Heap Underflow");
            return -1;
        }
        int max= heap[0];
        heap[0]=heap[heap_size-1];
        heap_size--;
        maxHeapify(0);
        return max;
    }
    int parent(int i)
    {
        return (i&1)==0
                ?(i/2)-1
                :i/2;
    }
    void swap(int i, int j)
    {
        int temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;

    }
    public void increase_key(int i, int ele)
    {
        heap[i]=ele;
        int parent=parent(i);
        while(i>=0 && heap[parent]<heap[i])
        {
            //swap
            swap(i,parent(i));
            i=parent(i);
            parent=parent(i);
        }
    }
    void insert(int ele)
    {
        heap_size++;
        heap[heap_size-1]=Integer.MAX_VALUE;
        increase_key(heap_size-1,ele);
    }
}
