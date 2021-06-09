package ChefProblems.src;/*
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChocolateProblemImpl {
    static int findRequiredTimeForChildren(ArrayList<Integer> al)
    {

    }
    static int findMinRequiredTime(int C, int A, int X, int B)
    {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(X);
        int initTime = findRequiredTimeForChildren(al);
        while(true){
            int nextChild = getNextChildTime(A,al.get(al.size()-1),B);
            al.add(nextChild);
            int newTime = findRequiredTimeForChildren(al);
            if(newTime>initTime)
            {
                break;
            }
            else
            {

            }
        }
    }
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList<>(a.size());
        int alice=0, bob=0;
        int i=-1;
        while(++i<a.size())
        {
            if(a.get(i)<b.get(i))
                bob+=1;
            else
                alice+=1;
        }
        list.add(alice);
        list.add(bob);
    }
    static int getNextChildTime(int A, int X,int B)
    {
        return (A*X)+B;
    }
}
*/
