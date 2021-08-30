package Dynamic_Programming;

import java.util.stream.IntStream;

public class PartitonSetIntoKSubsetWithEqualSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();

        if (k == 0 || sum % k != 0)
            return false;
        return solve(
                0,
                nums,
                k,
                new boolean[nums.length],
                0,
                sum / k
        );
    }

    public boolean solve(int idx,
                         int[] nums,
                         int buckets,
                         boolean[] taken,
                         int currbucketsum,
                         int targetbucketsum
    ) {
        if (buckets == 1)
            return true;
        if (currbucketsum == targetbucketsum) {
            solve(0, nums, buckets - 1, taken, 0, targetbucketsum);
        }
        for (int i = idx; i < nums.length; i++) {
            if (!taken[i]) {
                taken[i] = true;
                if (solve(idx + 1, nums, buckets, taken, currbucketsum + nums[i], targetbucketsum)) {
                    return true;
                }
                taken[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PartitonSetIntoKSubsetWithEqualSum().canPartitionKSubsets(new int[]{5,1, 4,2,3,2,3},4));
    }
}
