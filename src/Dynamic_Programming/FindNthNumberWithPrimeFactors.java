package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class FindNthNumberWithPrimeFactors {
    //LeetCode - https://leetcode.com/problems/ugly-number-ii/
    public int nthUglyNumber(int n) {
        List<Integer> uglyNos = new ArrayList<Integer>();
        uglyNos.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        System.out.println("n2\tn3\tn5\ti2\ti3\ti5\tuglyNos");
        while (uglyNos.size()<n){
            int n2 = uglyNos.get(i2) * 2;
            int n3 = uglyNos.get(i3) * 3;
            int n5 = uglyNos.get(i5) * 5;
            int next = Math.min(n2,Math.min(n3,n5));
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%s\t",n2,n3,n5,i2,i3,i5,uglyNos);
            System.out.println("Min = "+next);
            if(next==n2)
                i2++;
            if(next==n3)
                i3++;
            if(next==n5)
                i5++;
            uglyNos.add(next);
        }
        return uglyNos.get(uglyNos.size()-1);
    }
    /*
    n2	n3	n5	i2	i3	i5	uglyNos
    2	3	5	0	0	0	[1]	Min = 2
    4	3	5	1	0	0	[1, 2]	Min = 3
    4	6	5	1	1	0	[1, 2, 3]	Min = 4
    6	6	5	2	1	0	[1, 2, 3, 4]	Min = 5
    6	6	10	2	1	1	[1, 2, 3, 4, 5]	Min = 6
    8	9	10	3	2	1	[1, 2, 3, 4, 5, 6]	Min = 8

    8
     */
}
