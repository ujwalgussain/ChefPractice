package Amazon_Interview_Questions;

import utils.ArrayUtils;

import java.util.Arrays;

public class DutchFlagAlgoImpl {
    void arrange0sand1s(int arr[], int size)
    {
        /*Approach 1: count no of 0s and 1s and then create ans*/

        /*Approach 2: use 2 ptr technique*/
        /* Initialize left and right indexes */
        int left = 0, right = size - 1;

        while (left < right)
        {
            /* Increment left index until we see 1 at left */
            while (arr[left] == 0 && left < right)
                left++;

            /* Decrement right index until we see 0 at right */
            while (arr[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                arr[left++ ] = 0;
                arr[right--] = 1;
            }
        }
    }
    public void arrange0s1s2s()
    {
        /*Approach 1: count no of 0s, 1s, 2s and then create ans*/

        /*Approach 2:*/
        String str = "201220110";
        char arr[] = str.toCharArray();
        int lo=0,mid=0,hi=arr.length-1;
        while(mid<=hi)
        {
            switch (arr[mid])
            {
                case '0':
                {
                    ArrayUtils.swap(arr,lo,mid);
                    mid++;lo++;
                    break ;
                }
                case '1':
                {
                    mid++;
                    break;
                }
                case '2':
                {
                    ArrayUtils.swap(arr,hi,mid);
                    hi--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        new DutchFlagAlgoImpl().arrange0s1s2s();
    }
}
