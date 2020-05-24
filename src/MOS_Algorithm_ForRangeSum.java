import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Query {
    int l, r;
    Query(int a, int b)
    {
        l=a;r=b;
    }
}
public class MOS_Algorithm_ForRangeSum {

    public static void getAns(ArrayList<Query> q, int[] arr, int ans[])
    {
        int block=(int)Math.sqrt(arr.length);
        Collections.sort(q, new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                if(o1.l/block!=o2.l/block)
                {
                    return o1.l<o2.l?-1:1;
                }
                return o1.r<o2.r?-1:1;
            }
        });
        int currSum=0,currL=0,currR=0;
        System.out.println("L\tR\tcurrL\tcurrR\tcurrSum");
        for(Query query:q)
        {
            int L = query.l,R=query.r;
            System.out.printf("%d\t%d\t%d\t%d\t%d\n",L,R,currL,currR,currSum);
            while (currL<L)
            {

                currSum-=arr[currL++];
            }
            while(currL>L)
            {
                currSum+=arr[--currL];
            }
            while(currR<=R)
            {
                currSum+=arr[currR++];
            }
            while(currR>R+1)
            {
                currSum-=arr[--currSum];
            }
            System.out.printf("Sum of [%d to %d]=%d\n",L,R,currSum);
        }
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        ArrayList<Query> list = new ArrayList<>();
        list.add(new Query(1,2));
        list.add(new Query(0,4));
        list.add(new Query(3,8));
        list.add(new Query(4,5));
        int ans[] = new int[list.size()];
        getAns(list,arr,ans);
    }
}
