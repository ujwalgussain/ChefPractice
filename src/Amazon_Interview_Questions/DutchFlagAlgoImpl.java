package Amazon_Interview_Questions;

import java.util.Arrays;

public class DutchFlagAlgoImpl {
    public static void main(String[] args) {
        String str = "201220110";
        char arr[] = str.toCharArray();
        int lo=0,mid=0,hi=arr.length-1;
        while(mid<=hi)
        {
            switch (arr[mid])
            {
                case '0':
                {
                    char temp = arr[lo];
                    arr[lo]=arr[mid];
                    arr[mid]=temp;
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
                    char temp = arr[hi];
                    arr[hi]=arr[mid];
                    arr[mid]=temp;
                    hi--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
