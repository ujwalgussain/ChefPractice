package ChefProblems.src;

public class MaxSubArrayProblemImpl {

    static Result maxSubArrayProblem(int[] arr, int low, int high){
        if(low==high){
            //when only one element.
            return new Result(low, high, arr[low]);
        }
        else{
            int mid = (low+high)/2;
            Result left = maxSubArrayProblem(arr, low, mid); //this will return one element in the last recursive call
            Result right = maxSubArrayProblem(arr, mid+1,high);
            Result cross = maxCrossingSubArray(arr, low, mid, high);// this will be the addition of both left as well as right
            if(left.sum>=right.sum && left.sum>=cross.sum){
                return left;
            }else{
                if(right.sum>=left.sum && right.sum>=cross.sum){
                    return right;
                }else{
                    return cross;
                }
            }
        }

    }
    static Result maxCrossingSubArray(int arr[], int low, int mid, int high){
        int leftsum= Integer.MIN_VALUE;
        int sum=0, maxLeft=mid;
        for(int i=mid;i>=low;i--)
        {
            sum =sum+arr[i];
            if(sum>leftsum){
                leftsum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        int rightsum= Integer.MIN_VALUE, maxRight=mid+1;
        for(int i=mid+1; i<=high;i++)
        {
            sum = sum+arr[i];
            if(sum>rightsum)
            {
                rightsum = sum;
                maxRight = i;
            }
        }
        return new Result(maxLeft, maxRight,leftsum+rightsum);
    }
    static public void main(String args[])
    {
        int arr[] = new int[]{-2,-3,4,-1,-2,1,5,-3};

        Result res = maxSubArrayProblem(arr,0,arr.length-1);
        String s = "";
        for(int i=res.low;i<=res.high;i++)
        {
            s = s + " " +arr[i];
        }
        System.out.println("SubArray " + s + " Sum " + res.sum);
    }
}

class Result{
    int low, high, sum;
    Result(int low, int high, int sum)
    {
        this.low =low;
        this.high = high;
        this.sum=sum;
    }
}