package a_practiceproblems.divideandconquer;

import utils.ArrayUtils;

import static utils.ArrayUtils.swap;

public class QuickSort {
    void quickSort(int[] a, int l, int r){
        if(l<r){
            int q = partition(a, l,r);
            quickSort(a,l,q-1);
            quickSort(a,q+1,r);
        }
    }
    int partition(int[] a, int l, int r) {
        int pivot = a[r]; //pivot
        int i = l-1;
        for (int j = l; j < r; j++) {
            if(a[j]<=pivot){
                swap(a,++i,j);
            }
        }
        swap(a,i+1,r);
        return i+1;
    }
}
