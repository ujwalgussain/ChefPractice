package Sorting_Algos;

public class Kadane_AlgoImpl {
    static void getMaxSubArray(int[] arr)
    {
        int max_so_far=0, max_ending_here=0;
        int start=-1, end=-1,count=0;
        for(int i:arr)
        {
            max_ending_here+=i;
            if(max_ending_here<0){
                max_so_far=0;
                max_ending_here=0;
                start=count+1;
            }
            if(max_so_far<max_ending_here)
            {
                max_so_far=max_ending_here;end = count;
            }
            count++;
        }
        String s = "";
        for(int i=start;i<=end;i++){
           s=s+" "+arr[i];
        }
        System.out.println("Max Sum =" + max_so_far+" SubArr = "+s);
    }

    static public void main(String args[])
        {
        int arr[] = new int[]{-2,-3,4,-1,-2,1,5,-3};
        getMaxSubArray(arr);
    }
}
