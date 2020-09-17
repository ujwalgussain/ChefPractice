package Amazon_Interview_Questions;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;

public class ReverseLLInGroupsofK {
    static boolean headChanged=false;
    static LLNode reverse(LinkedList list, LLNode start, int count)
    {
        LLNode temp = start;

        LLNode prev = null,next=null;
        int c=-1;
        System.out.println(temp.getData());
        while(temp!=null && ++c<count)
        {
            next=temp.getNext();
            temp.setNext(prev);
            prev=temp;
            temp=next;
        }
        if(!headChanged)
        {
            list.setHead(prev);
            headChanged=true;
        }
        if(next!=null)
            start.setNext(reverse(list,next,count));

        return prev;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAll(1,2,3,4,5,6);
        reverse(list, list.getHead(), 3);
        list.display();
    }
}
