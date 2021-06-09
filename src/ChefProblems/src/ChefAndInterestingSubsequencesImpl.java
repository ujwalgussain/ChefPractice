package ChefProblems.src;

import java.util.Scanner;
import java.util.TreeMap;

public class ChefAndInterestingSubsequencesImpl {
    static TreeMap<Integer,Integer> map = new TreeMap<>();
    static int min=Integer.MAX_VALUE,count=0;
    public static void processAllSubsequences(int arr[], int k,int len, int i, int sum)
    {
        if(sum>min){
            return;
        }
        if(len == k)
        {
            if(sum<min)
            {
                min = sum;
                count=1;
            }
            else
            {
                if(sum == min)
                    count++;
            }

            return;
        }
        if(len>k|| i == arr.length)
            return;
        processAllSubsequences(arr,k,len+1,i+1, sum+arr[i]);
        processAllSubsequences(arr,k,len,i+1,sum);
    }
    static String sets="";
    public static void processAllSubsequencesWithString(int arr[], int k,int len, int i, int sum, String s)
    {
       /* if(!map.isEmpty() && sum>map.firstKey()){
            System.out.println("Failed for Set " + s);
            return;
        }*/
        System.out.println("Set " +s);
        if(len == k)
        {
            //System.out.println("Set -> "+s + " Sum -> "+ sum + " Map " + map);
            map.put(sum,map.containsKey(sum)?map.get(sum)+1:1);
            System.out.printf("Stop set %s\n",s);
            sets+=" "+s;
            return;
        }
        if(len>k|| i == arr.length)
            return;
        processAllSubsequencesWithString(arr,k,len+1,i+1, sum+arr[i],s+arr[i]);
        processAllSubsequencesWithString(arr,k,len,i+1,sum,s);
    }


    public static int get(int arr[], int k)
    {
        processAllSubsequencesWithString(arr,k,0,0,0,"");
        System.out.println(sets);
        return map.firstEntry().getValue();
       //return count;
    }

    public static int iterative(int arr[], int k)
    {
        map = new TreeMap<>();
        int n = arr.length;
        int pow_n = 1<<n;
        for (int i=0;i<pow_n;i++)
        {
            int sum= 0,len=0; String s="";
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                   sum+=arr[j];len++;s+=arr[j];
                }
                if(len>k)
                    break;
            }
            if(len == k){
                System.out.printf("Set {%s} Sum %s\n",s,sum);
                map.put(sum, map.containsKey(sum)?map.get(sum)+1:1);
            }
        }
        System.out.println("Map " + map);
        return map.firstEntry().getValue();
    }
    static public void main(String a[])
    {
        Scanner sc = new Scanner(System.in);
        int test = 0;
        if(sc.hasNext())
            test = sc.nextInt();
        int i =-1;
        while(++i<test)
        {
            int n = 0;
            if(sc.hasNext())
                n = sc.nextInt();
            int k = 0;
            if(sc.hasNext())
                k=sc.nextInt();
            int arr[] = new int[n];
            int j = -1;
            while(++j<n)
            {
                if(sc.hasNext())
                arr[j]=sc.nextInt();
            }
            System.out.println(get(arr,k));
           // System.out.println(iterative(arr,k));
        }
    }
}
/*class test
{
    static TreeMap<Integer,Integer> map = new TreeMap<>();
    public static int iterative(int arr[], int k)
    {
        map = new TreeMap<>();
        int n = arr.length;
        int pow_n = 1<<n;
        for (int i=0;i<pow_n;i++)
        {
            int sum= 0,len=0;
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                    sum+=arr[j];len++;
                }
                if(len>k)
                    break;
            }
            if(len == k){
                map.put(sum, map.containsKey(sum)?map.get(sum)+1:1);
            }
        }
        return map.firstEntry().getValue();
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = 0;
        if(sc.hasNext())
            test = sc.nextInt();
        int i =-1;
        while(++i<test)
        {
            int n = 0;
            if(sc.hasNext())
                n = sc.nextInt();
            int k = 0;
            if(sc.hasNext())
                k=sc.nextInt();
            int arr[] = new int[n];
            int j = -1;
            while(++j<n)
            {
                if(sc.hasNext())
                    arr[j]=sc.nextInt();
            }
            System.out.println(iterative(arr,k));
        }
    }
}*/