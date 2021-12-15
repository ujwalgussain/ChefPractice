package a_practiceproblems.ArrayProblems.slidingwindow.countingsubarrays.sum;

import java.util.Arrays;
import java.util.LinkedList;

public class CountSubArrayWithSumGreaterThanK {
    /*public static int solve(int[] nums, int k){
        int prefixSum[] = new int[nums.length+1];
        int res=0;
        for(int i=0;i< nums.length;i++)
            prefixSum[i+1] = prefixSum[i]+nums[i];
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && prefixSum[q.peekLast()]>=prefixSum[i])
                q.pollLast();
            while (!q.isEmpty() && prefixSum[i]-prefixSum[q.peek()]>=k){
                res++;
                q.poll();
            }
            q.add(i);
        }
        return res;
    }
*/
    // Function to find required value
    static int findCnt(int arr[], int n, int k)
    {
        // Variable to store final answer
        int ans = 0;

        // Loop to find prefix-sum
        for (int i = 1; i < n; i++)
        {
            arr[i] += arr[i - 1];
            if (arr[i] > k || arr[i] < -1 * k)
                ans++;
        }

        if (arr[0] > k || arr[0] < -1 * k)
            ans++;

        // Sorting prefix-sum array
        Arrays.sort(arr);

        // Loop to find upper_bound
        // for each element
        for (int i = 0; i < n; i++)
            ans += n - upper_bound(arr, 0, n, arr[i] + k);

        // Returning final answer
        return ans;
    }

    static int upper_bound(int[] a, int low,
                           int high, int element)
    {
        while(low < high)
        {
            int middle = low + (high - low)/2;
            if(a[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(findCnt(new int[]{1,2,0,0,4,5,3},7,3));
    }
}
