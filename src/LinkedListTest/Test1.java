package LinkedListTest;

import java.util.HashSet;

public class Test1 {
    static boolean findAns(LinkedList l, int N)
    {
        Node temp = l.head;
        HashSet<Integer> traversed = new HashSet<>();
        while (temp!=null)
        {
            int ans =(N+ temp.data);

            if(traversed.contains(ans))
                return true;
            traversed.add(temp.data);
            temp=temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insertAll(4,7,2,1,13);
        System.out.println(findAns(l,6));
    }
}
