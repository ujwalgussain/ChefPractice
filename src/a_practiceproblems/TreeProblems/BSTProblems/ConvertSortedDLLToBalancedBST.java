package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.linkedlistproblems.dll.DLLNode;
import a_practiceproblems.linkedlistproblems.dll.DoublyLinkedList;
import a_practiceproblems.linkedlistproblems.dll.problems.GetMiddleOfDLL;

import java.util.Optional;

public class ConvertSortedDLLToBalancedBST {

    public static DLLNode convert(DLLNode head)
    {
        if(head == null || head.next == null) {
            if(head !=null) {
                head.next = null;
                head.prev = null;
            }
            return head;
        }
        DLLNode temp,p,q;
        temp = GetMiddleOfDLL.get(head);
        /*System.out.println(String.format("When head is %s the mid is %s",head.data,temp.data));*/
        p = head;
        while(p.next != temp)
            p=p.next;
        p.next = null;
        q = temp.next;
        temp.next = null;
        temp.prev = convert(head);
        temp.next = convert(q);
        /*System.out.println(String.format("temp=%s prev=%s next=%s",temp.data,
                Optional.ofNullable(temp.prev)
                        .map(DLLNode::getData),
                Optional.ofNullable(temp.next)
                        .map(DLLNode::getData)
                ));*/
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = DoublyLinkedList.of(1,2,3,4,5,6);
        dll.head = convert(dll.head);
        /*System.out.println("HEAd--" + dll
        .head.data);
        */
        inorder(dll.head);
    }
    public static void inorder(DLLNode root)
    {
        if(root != null)
        {
            /*System.out.println(String.format("root=%s prev=%s next=%s",root.data,
                    Optional.ofNullable(root.prev)
                            .map(DLLNode::getData).orElse(null),
                    Optional.ofNullable(root.next)
                            .map(DLLNode::getData).orElse(null)
            ));*/
            inorder(root.prev);
            System.out.println(root.data);
            inorder(root.next);
        }
    }
}
