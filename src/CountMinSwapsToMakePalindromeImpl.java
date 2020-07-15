import java.util.Arrays;

public class CountMinSwapsToMakePalindromeImpl {
    static int getCount(String str)
    {
        int count=0;
        char arr[] = str.toCharArray();
        int N = str.length();
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
                return -1;
            for(int j=right;j<N-i-1;j++)
            {
                char t = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = t;
                System.out.println(Arrays.toString(arr));
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount("aabbc"));
    }
}
