import java.util.*;


public class TestClass {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        for(int i = 0; i<A.size()-2;i++)
        {
            if(i>0 && A.get(i-1)==A.get(i))
                continue;
            int l = i+1,r=A.size()-1;
            while(l<r)
            {
                System.out.printf("%s-%s-%s\n",i,l,r);
                double sum  = ((double)A.get(i)) + A.get(l) + A.get(r);
                if(sum==0)
                {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(A.get(i));
                    a.add(A.get(l));
                    a.add(A.get(r));
                    ans.add(a);
                    l++;
                }
                else
                {
                    if(sum>0)
                        r--;
                    else
                        l++;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        System.out.println(new TestClass().threeSum(new ArrayList<>(Arrays.asList(2147483647,-2147483648,-2147483648,0,1))));
    }
}

