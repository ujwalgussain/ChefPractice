package OldProblems.src;

import java.util.Arrays;

public class MergeSortImpl {
    static void mergeSort(int[] arr, int start,int end)
    {
        if(start<end)
        {
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start,mid,end);
        }
    }
    static void merge(int arr[], int start, int mid, int end)
    {
        System.out.println("start = " +start + " mid = " + mid  + " end = " + end) ;
        int[] a = new int[mid-start+2];
        int[] b = new int[end-(mid)+1];
        for(int i=0;i<a.length-1;i++)
        {
            a[i] = arr[start+i];
        }
        a[a.length-1]=Integer.MAX_VALUE;
        for(int i=0;i<b.length-1;i++) {
            b[i] = arr[mid + 1 + i];
        }
        b[b.length-1]=Integer.MAX_VALUE;
        System.out.println("a = " + Arrays.toString(a)+ " b = " + Arrays.toString(b));
        int i=0,j=0;
        for(int r=start;r<=end;r++)
        {
            System.out.println(a[i]+ " " + b[j]);
            if(a[i]<b[j])
            {

                arr[r] = a[i++];
            }
            else
            {

                arr[r] = b[j++];
            }
        }
    }
    public static void main(String... args)
    {
        int a[] = new int[]{9,8,7,4,5,6};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
