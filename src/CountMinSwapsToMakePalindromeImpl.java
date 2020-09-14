import java.util.Arrays;

public class CountMinSwapsToMakePalindromeImpl {
    static int getCount(String str)
    {
        int count=0;
        char arr[] = str.toCharArray();
        int N = str.length();
        boolean flag=false;
        for(int i=0;i<N/2;i++)
        {
            int right=N-i-1;
            while(i<right)
            {
                if(arr[i]==arr[right])
                    break;
                right--;
            }
            if(i==right)
            {
                if(!flag && (N&1)==1)
                {
                    //swap to mid
                    int mid=N/2;
                    while(right<mid)
                    {
                        char t = arr[right];
                        arr[right] = arr[right + 1];
                        arr[right + 1] = t;
                        right++;
                        count++;
                    }
                    flag=true;
                    continue;
                }
                else
                {
                    return -1;
                }
            }
                
            for(int j=right;j<N-i-1;j++)
            {
                char t = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = t;
                System.out.println(Arrays.toString(arr));
                count++;
            }
        }
        System.out.println("Final Ans " + Arrays.toString(arr));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount("ntini"));
    }
}
