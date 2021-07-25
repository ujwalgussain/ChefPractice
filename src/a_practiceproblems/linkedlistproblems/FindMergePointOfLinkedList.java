package a_practiceproblems.linkedlistproblems;

public class FindMergePointOfLinkedList {
    /*Approach 1: Traverse the list one by one and store all nodes in list. If node already present in the list then return node*/
    /*Approach 2: If lists are not equal in length then start after skipping the extra nodes in the list. Now traverse both
    *               lists and check whether next of both nodes is same. If yes then return*/
    static void findMergePoint(LinkedList list1, LinkedList list2)/*Approach 2*/
    {
        LLNode temp1=list1.head,temp2=list2.head;

        if(list1.length>list2.length)
        {
            int offset=list1.length-list2.length;
            while(--offset>=1)
            {
                temp1=temp1.next;
            }
        }
        else
        {
            int offset=list2.length-list1.length;
            while(--offset>=0)
            {
                temp2=temp2.next;
            }
        }
        System.out.println(temp1.data+" "+temp2.data);
        while(temp1.next!=temp2.next)
        {
            temp1=temp1.next;
            temp2= temp2.next;
        }
        System.out.println("Merge Point- "+temp1.next.data);
    }
    public static void main(String[] args) {
        /*
        * 1-2-3
        *       \
        *        6-7
        *       /
        *   4-5
        * */
        LLNode n1 = new LLNode(1);
        LLNode n2 = new LLNode(2);
        LLNode n3 = new LLNode(3);
        LLNode n4 = new LLNode(4);
        LLNode n5 = new LLNode(5);
        LLNode n6 = new LLNode(6);
        LLNode n7 = new LLNode(7);
        LinkedList list1=new LinkedList();
        list1.insertNode(n1);
        list1.insertNode(n2);
        list1.insertNode(n3);
        list1.insertNode(n6);
        list1.insertNode(n7);
        LinkedList list2=new LinkedList();
        list2.insertNode(n4);
        list2.insertNode(n5);
        list2.insertNode(n6);
        list1.display();
        list2.display();
        findMergePoint(list1,list2);
    }
}
