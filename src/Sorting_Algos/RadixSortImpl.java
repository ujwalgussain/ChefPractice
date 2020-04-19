package Sorting_Algos;

import java.util.*;

public class RadixSortImpl {
    public static void main(String args[])
    {
        // your code goes here
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int max=-1;
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
            max=Math.max(max,arr[i]);
        }
        int len=(int)Math.floor(Math.log10(max)+1);
        int ans[] = new int[N];
        int mod=10;
        while(--len>=0)
        {
            TreeMap<Integer, List<Integer>> buckets= new TreeMap<>();
            System.out.println("Mod "+mod);
            for(int i=0;i<N;i++)
            {
                int key=arr[i]%mod;
                List<Integer> list;
                if(buckets.containsKey(key))
                    list = buckets.get(key);
                else
                {
                    list = new ArrayList<>();
                    buckets.put(key,list);
                }
                list.add(arr[i]);
            }
            int ptr=0;
            for(List<Integer> values:buckets.values())
            {
                System.out.println(values);
                for(int i:values)
                {
                    ans[ptr++]=i;
                }
            }
            mod*=10;
        }
        System.out.println(Arrays.toString(ans));
    }
}
