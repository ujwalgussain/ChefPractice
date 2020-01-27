package OldProblems.src;

public class MaxSubArrayBruteForceImpl {
    static Result findMaxSubArray(int arr[])
    {
        Result res = new Result(-1,-1,Integer.MIN_VALUE);
        for(int i=0;i<arr.length-1;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum>res.sum)
                {
                    System.out.println("Found " + sum);
                    res.sum = sum;
                    res.low=i;
                    res.high=j;
                }
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{-5,-4,5,3,-8,-10};
        Result res = findMaxSubArray(arr);
        String s = "";
        for(int i=res.low;i<=res.high;i++)
        {
            s = s + " " +arr[i];
        }
        System.out.println("SubArray " + s + " Sum " + res.sum);

    }
}
