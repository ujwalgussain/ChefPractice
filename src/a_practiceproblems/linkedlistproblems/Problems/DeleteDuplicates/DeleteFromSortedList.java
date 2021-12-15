package a_practiceproblems.linkedlistproblems.Problems.DeleteDuplicates;

import a_practiceproblems.linkedlistproblems.LLNode;


public class DeleteFromSortedList {
    public static void deleteDuplicatesFromSortedLinkedList(LLNode l)
    {
        System.out.println("Created LinkedList "+l);
        LLNode temp = LLNode.createList(1,1,2,2,2,2,3,3,3,3,3,4,4,4,5);
        while(temp !=null)
        {
            System.out.println("For "+temp.data);
            while(temp.next != null && temp.data == temp.next.data)
            {
                System.out.println("found duplicate");
                //delete the next node
                LLNode nextNode = temp.next;
                temp.next=nextNode.next;
                nextNode.next=null;
            }
            temp=temp.next;
        }
        System.out.println("After removing duplicates "+l);
    }
}
