package OldProblems.src;

public class PairThatFormsASumImpl {
    public static void findPairSortedApproach(int arr[], int given_sum)
    {
        int i=arr.length-1,j=0;
        while(i>=0&&j<arr.length)
        {
            //System.out.println(i+" " + j);
            int sum = arr[i]+arr[j];
           // System.out.println("Sum " + sum);
            if(sum==given_sum)
            {
               System.out.println(String.format("Found %s,%s",arr[i],arr[j]));
                i--;
            }
            else
            {
                if(sum>given_sum)
                {
                    i--;
                }
                else{
                    j++;
                }
            }
        }

    }

    public static void main(String args[])
    {
        findPairSortedApproach(new int[]{1,2,3,4,5},6);
    }
}
