package Amazon_Interview_Questions;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOf2ListsLikeAdder {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = Stream.of(9,9).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> list2 = Stream.of(9,9).collect(Collectors.toCollection(LinkedList::new));
        int carry=0;
        LinkedList<Integer>  ansList = new LinkedList<>();
        while(!list1.isEmpty() || !list1.isEmpty())
        {
            int a=0,b=0,ans=0;
            if(!list1.isEmpty())
                a= list1.pollFirst();
            if(!list2.isEmpty())
                b=list2.pollFirst();
            ans = a+b+carry;
            System.out.printf("%d + %d + %d = %d\n",a,b,carry,ans);
            if(ans>9)
            {
                carry=ans/10;
                ans=ans%10;
            }
            else
            {
                carry = 0;
            }
            ansList.add(ans);
        }
        if(carry>0)
        {
            ansList.add(carry);
        }
        System.out.println(ansList);
    }
}
