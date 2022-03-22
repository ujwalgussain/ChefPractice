package a_practiceproblems.divideandconquer.mergesort;

public class CountInversions {
    public static void main(String[] args) {
        System.out.println(inversionCount(new long[]{2,4,3,1,5}, 5));
    }
    static long inversionCount(long arr[], long N) {
        int n = (int) N;
        return mergeSort(arr, new long[n], 0, n - 1);
    }

    static long mergeSort(long arr[], long temp[], int i, int j) {
        long invCount = 0;
        if (i < j) {
            int m = (i + j) / 2;
            invCount += mergeSort(arr, temp, i, m);
            invCount += mergeSort(arr, temp, m + 1, j);
            invCount += merge(arr, temp, i, m, j);
        }
        return invCount;
    }

    static long merge(long arr[],long temp[],int left,int mid,int right)
    {
        long inv_count=0;
        int i = left;
        int j = mid+1;
        int k = left;
        while((i <= mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid+1 - i);
            }
        }

        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= right)
            temp[k++] = arr[j++];

        for(i = left ; i <= right ; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}
