package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    public static int trap(final List<Integer> A) {
        int n = A.size();

        int left_max[] = new int[n];
        left_max[0] = Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++)
        {
            left_max[i] = Math.max(left_max[i-1],A.get(i-1));
        }
        int right = Integer.MIN_VALUE;
        int ans=0;
        for(int i=n-2;i>0;i--)
        {
            right = Math.max(right,A.get(i+1));
            int minV = Math.min(right,left_max[i]);
            if(minV>A.get(i))
                ans+=(minV-A.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new ArrayList<>(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))));
    }
}
