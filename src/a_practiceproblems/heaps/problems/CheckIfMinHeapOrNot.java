package a_practiceproblems.heaps.problems;

public class CheckIfMinHeapOrNot {
    static boolean checkMinHeap(int A[], int idx, int heap_size) {
        int left_idx = (2 * idx) + 1, right_idx = left_idx + 1;
        if (left_idx > heap_size)
            return true;
        return A[idx] < A[left_idx] &&
                (right_idx > heap_size || A[idx] < A[right_idx]) &&
                checkMinHeap(A, left_idx, heap_size) && checkMinHeap(A, right_idx, heap_size);
    }

    public static void main(String[] args) {
        System.out.println(checkMinHeap(new int[]{1, 2, 3, 6, 4, 5}, 0, 5));
        System.out.println(checkMinHeap(new int[]{1, 12, 3, 6, 4, 5}, 0, 5));
        System.out.println(checkMinHeap(new int[]{1, 2, 3, 6, 4, 0}, 0, 5));
    }
}
