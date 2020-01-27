package OldProblems.src.KnapSackProblem;


import java.util.Set;

public class KnapsackDPImpl {
    static int KnapsackDP(int capacity, Weight wts[], int n, String s)
    {
      //  System.out.println(String.format(" KnapsackDP(capacity = %s, wts[], n=%s)",capacity,n));
        if(capacity==0||n> wts.length-1) {
            System.out.println(s);
            /*System.out.println("Return 0");*/
            return 0;
        }
        if(capacity<wts[n].wt) //this ensures that capacity will never be negative
        {
//            System.out.println("Capacity is lesser n = " +(n+1));
            return KnapsackDP(capacity,wts,n+1,s);
        }
       // System.out.println(String.format("\t\t\tPROFIT1 - > %s + KnapsackDP(%s,wts,%s)",wts[n].profit,(capacity-wts[n].wt),(n+1)));
        int profit1 = wts[n].profit + KnapsackDP(capacity-wts[n].wt,wts,n+1,s.concat(wts[n].toString()+" "));
       // System.out.println(String.format("\t\t\tPROFIT2 - > KnapsackDP(%s,wts,%s)",capacity,n+1));
        int profit2 =KnapsackDP(capacity,wts,n+1,s);
       // System.out.println("P1 = " + profit1 + " P2= " + profit2);
        return Math.max(profit1,profit2);
    }
    static void subsets(int arr[], int n, String s, Set<String> set) {
        if (n == arr.length){
            set.add(s);
            return;
        }


        subsets(arr,n+1,s.concat(arr[n]+""),set);
        subsets(arr,n+1,s,set);
    }
    public static void main(String args[])
    {
        /*Set<String> s = new HashSet<>();
        subsets(new int[]{1,2,3},0,"",s);
        System.out.println(s);*/
        Weight wt[] = new Weight[]{new Weight(10,60),new Weight(20,60),new Weight(30,90)};
        System.out.println(KnapsackDP(50,wt,0,""));
    }
}
