package Heaps;

public class MinHeap {
    int heap[] = new int[1000];
    int heap_size=0;
    public void display()
    {
        for (int i = 0; i < heap_size; i++) {
            System.out.printf("%d ",heap[i]);
        }
        System.out.println();
    }
    public int getMin()
    {
        return heap[0];
    }
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
            minHeapify(i);
        }
    }
    public void minHeapify(int i)
    {
        int left = (i<<1)+1;
        int right= (i<<1)+2;
        int smallest = i;
        if(left<heap_size && heap[left]<heap[smallest])
        {
            smallest=left;
        }
        if(right<heap_size && heap[right]<heap[smallest])
        {
            smallest=right;
        }
        if(smallest != i )
        {
            swap(i,smallest);
            minHeapify(smallest);
        }
    }
    public int extractMin()
    {
        if(heap_size==0)
        {
            System.out.println("Heap Underflow");
            return -1;
        }
        int max= heap[0];
        heap[0]=heap[heap_size-1];
        heap_size--;
        minHeapify(0);
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
        /*heap[i]=ele;
        int parent=parent(i);
        while(i>0 && heap[parent]>heap[i])
        {
            //swap
            swap(i,parent(i));
            i=parent(i);
            parent=parent(i);
        }*/
        //In a min heap increase key means go down

    }
    public  void insert(int ele)
    {
        heap_size++;
        heap[heap_size-1]=Integer.MAX_VALUE;
        increase_key(heap_size-1,ele);
    }
    public void replaceMin(int ele)
    {
        heap[0]=ele;
        minHeapify(0);
    }
}
