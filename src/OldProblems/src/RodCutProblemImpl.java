package OldProblems.src;

import java.util.Map;
import java.util.TreeMap;

public class RodCutProblemImpl {

    static int cutRod(int prices[], int n){
        System.out.print("Call "+n);
        if(n<0){
            System.out.println("Return 0");
            return 0;
        }
        if(n==0)
        {
            return prices[0];
        }
        int q = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int res = prices[i]+cutRod(prices,n-i-1);
            q = Math.max(q,res);
            System.out.println("For n = " +n+" [ q="+q+" res=" + res+"]");
        }
        return q;
    }
    static int cutRod(TreeMap<Integer,Integer> pricesMap, int n){
        System.out.print("Call "+n);
        if(n==0){
            System.out.println("Return 0");
            return 0;
        }

        int q = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:pricesMap.entrySet())
        {
            System.out.println("Entry : "+ entry);
           Integer len = entry.getKey();
           Integer cost = entry.getValue();
           if(len>n)
               break;
            q = Math.max(q,cost+cutRod(pricesMap,n-len));
        }
        return q;
    }
    static public void main(String args[])
    {
        System.out.println("Ans " + cutRod(new int[]{1,5,8,9,10,17},4) + "\n");
       /* TreeMap<Integer,Integer> pricesMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o1.compareTo(o2);
            }
        });
        pricesMap.put(1,1);
        pricesMap.put(2,5);
        pricesMap.put(3,8);
        pricesMap.put(4,9);
        pricesMap.put(5,10);
        pricesMap.put(6,17);
        pricesMap.put(7,18);
        pricesMap.put(1,19);
        System.out.println("Ans = " + cutRod(pricesMap, 4));*/

    }
}
