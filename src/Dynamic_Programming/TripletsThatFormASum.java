package Dynamic_Programming;

public class TripletsThatFormASum {
    public static void  findTriplets(int arr[], int given_sum)
    {
        int pivot=0, i=pivot+1, j=arr.length-1;
        while(pivot!=arr.length-2)
        {
            if(i==j)
            {
                pivot++;
                i=pivot+1;
                j=arr.length-1;

            }
            int sum = arr[pivot]+ arr[i]+arr[j];
            if(sum ==given_sum){
                System.out.println(String.format("Triplets are %s,%s,%s",arr[pivot],arr[i], arr[j]));
                j--;
            }
            else
            {
                if(sum>given_sum)
                    j--;
                else
                    i++;
            }
        }
    }
    static public void main(String ars[])
    {
        findTriplets(new int[]{1,2,3,4,5,6},10);
    }
}
