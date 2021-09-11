package Dynamic_Programming.udemy;

import java.util.stream.IntStream;

public class SumOfRange {
    //Logic : Calculate sumupto[i] for all elements
    // sum [i,j] = sumupto[j] - sumupto[i-1] if 1<=i<=n

    public int getSumInRange(int arr[], int l, int r) {
        int n = arr.length;
        if (l < 0 || r >= n)
            throw new IllegalArgumentException();
        int sumupto[] = new int[n];
        sumupto[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumupto[i] = sumupto[i - 1] + arr[i];
        }
        return l == 0
                ? sumupto[r]
                : sumupto[r] - sumupto[l - 1];
    }

    public static void main(String[] args) {
        System.out.println(new SumOfRange().getSumInRange(new int[]{1, 2, 3, 4, 5}, 1, 3));
    }
}
