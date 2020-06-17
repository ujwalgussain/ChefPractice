import java.util.Arrays;

public class PythagoreanTripletImpl {
    public static void naiveApproach(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n-2;i++)
        {
            int i2=arr[i]*arr[i];
            for(int j=i+1;j<n-1;j++)
            {
                int j2=arr[j]*arr[j];
                for(int k=j+1;k<n;k++)
                {
                    int k2=arr[k]*arr[k];
                    if(i2==(j2+k2) || j2==(i2+k2) || k2==(i2+j2)) //VVImp************
                    {
                        System.out.printf("Triplet Found (%d,%d,%d)\n",arr[i],arr[j],arr[k]);
                    }
                }
            }
        }
    }
    public static void efficientApproach(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++) {
            arr[i]=arr[i]*arr[i];
        }
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--)
        {
            int left=0,right=i-1;
            while(left<right)
            {
                int sum = arr[left]+arr[right];
                if(arr[i] == sum)
                {
                    System.out.printf("Triplet Found (%f,%f,%f)\n",Math.sqrt(arr[i]),Math.sqrt(arr[left]),Math.sqrt(arr[right]));
                    break;
                }
                else
                {
                    if(arr[i]>sum)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,4,6,5};
        naiveApproach(arr);
    }
}
