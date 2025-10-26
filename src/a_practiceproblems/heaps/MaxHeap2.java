package a_practiceproblems.heaps;

public class MaxHeap2 {

    int[] heap = new int[100000];
    int size = 0;

    public void initializeHeap() {

    }

    public void insert(int key) {
        size++;
        heap[size - 1] = Integer.MIN_VALUE;
        changeKey(size - 1, key);
    }

    public void changeKey(int index, int newVal) {
        if (index >= size) {
            return;
        }
        heap[index] = newVal;
        int parent = parent(index);
        while (parent >= 0 && heap[index] > heap[parent]) {
            swap(parent, index);
            index = parent;
            parent = parent(index);
        }
    }

    int parent(int idx) {
        return (idx - 1) / 2;
    }

    public void extractMax() {
        if (size == 0) {
            return;
        }
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMax() {
        return heap[0];
    }

    public int heapSize() {
        return size;
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void maxHeapify(int idx) {
        int left = (2 * idx) + 1;
        int right = (2 * idx) + 2;
        int largest = idx;
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != idx) {
            swap(idx, largest);
            maxHeapify(largest);
        }
    }
}
