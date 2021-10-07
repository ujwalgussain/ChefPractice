package Dynamic_Programming;

import java.util.HashSet;
import java.util.Set;

public class SetOfNosThatFormASumCSDojo {
    static Set<String> sets = new HashSet<>();
    static void getNoOfSetThatFormASum(int data[],int total, int i,String s)
    {
        if(i==data.length || total<0)
            return;
        if(total==0){
            //System.out.println("*");
            sets.add(s);
            return;
        }
        if(total<data[i])
            getNoOfSetThatFormASum(data,total,i+1,s);
        else
            getNoOfSetThatFormASum(data,total-data[i],i+1,s+" "+data[i]);
            getNoOfSetThatFormASum(data, total,i+1,s);
    }

    static public void main(String... args)
    {
        int data[] = new int[]{1,2,3,4,5,6,7};
        getNoOfSetThatFormASum(data,6,0,"");
        System.out.println(sets);
    }
}
