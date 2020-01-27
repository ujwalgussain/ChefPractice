package OldProblems.src;

import java.util.TreeSet;

public class FindAllSubsetsOfASetImpl {
    TreeSet<String>  set = new TreeSet<>(); //This is for The recusrsive approach

    public static void rec_printAllSubsets(int arr[], int i, TreeSet<Integer> s)
    {
        if(i == arr.length)
        {
            System.out.println(s);
        }
        else
        {
            TreeSet<Integer> s1= new TreeSet<>(s);
            s1.add(arr[i]);
            rec_printAllSubsets(arr,i+1,s1);
            rec_printAllSubsets(arr,i+1,s);

        }
    }
    public static void iterative_printAllSubsets(int arr[])
    {
        int len = 1<<arr.length;
        for(int i = 0;i<len;i++)
        {
            System.out.print("{");
            for(int j = 0;j<arr.length;j++)
            {
                if( (i & (1<<j)) >0)
                {
                    System.out.print(arr[j]);
                }
            }
            System.out.println("}");
        }
    }
    static public void main(String args[])
    {

        rec_printAllSubsets(new int[]{1,12,23,45},0,new TreeSet<>());

            //iterative_printAllSubsets(new int[]{1,2,3});

    }


}
