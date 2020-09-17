package Sorting_Algos;

import java.util.Arrays;

public class Sorting0sAnd1s {
    public static void main(String[] args) {
        String str = "0101110101000010";
        int low=0,high=str.length()-1;
        char[] arr = str.toCharArray();
        while(low<high)
        {
            if(arr[low]=='0')
            {
                low++;
            }
            else {
                char temp = arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
