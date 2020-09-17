package LinkedListTest;

import java.util.HashSet;
import java.util.Stack;

public class ProblemsForPractice {
    static LinkedList l;
    static void buildLinkedList()
    {
        l = new LinkedList();
        l.insertAll(1,2,3,4,5,6);
        System.out.println("Created LinkedList "+l);
    }
    static void buildLoopedLinkedList()
    {
        l = new LinkedList();
        l.insertAll(1,2,3,4,5,6);
        LLNode temp=l.head;
        while(temp.next!=null) {
            temp = temp.next;
        }

        LLNode n = new LLNode(7);
        temp.next=n;
        n.next = l.head.next.next;
    }
    static boolean findAns(LinkedList l, int N)
    {
        LLNode temp = l.head;
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
    static LLNode getNthNode(int n)
    {
        int c=1;
        LLNode res=null;
        LLNode temp=l.head;
        while(temp!=null)
        {
            temp=temp.next;
            if(c==n-1)
            {
                res=temp;break;
            }
            c++;
        }
        return res;

    }
    static LLNode getNthNodefromEnd(int n)
    {
        LLNode temp=l.head;
        int c=0;
        while(temp!=null && c<n)
        {
            temp=temp.next;c++;
        }
        if(temp==null)
            return null;
        LLNode nthLastNode = l.head;
        while(temp != null)
        {
            temp=temp.next;
            nthLastNode=nthLastNode.next;
        }
        return nthLastNode;

    }
    static LLNode getMiddleOfLinkedList()
    {
        /*In odd length fastptr will come at lastNode
           In even length slowptr will come at secondLast node
        * */
        buildLinkedList();
        LLNode fastptr=l.head,slowptr=l.head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
        }
        return slowptr;
    }
    static boolean detectLoopInLinkedList()
    {
        /*
        * Approach 1: Visit each Node and put in hashset. While traversing check whether Node is already visited
        * Approach 2: Use Floyd's cycle detection algorithm*/
        buildLoopedLinkedList();
        LLNode fast_p=l.head,slow_p=l.head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;

    }
    static int getLengthOfLoopInLinkedList()
    {
        buildLoopedLinkedList();
        LLNode fastptr = l.head,slowptr = l.head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr = fastptr.next.next;
            slowptr=slowptr.next;
            if(slowptr==fastptr)
            {
                slowptr = slowptr.next;int count=1;
                while(slowptr != fastptr)
                {
                    slowptr=slowptr.next;count++;
                }
                return count;
            }
        }
        return 0;
    }
    static void buildPalindromicLinkedList()
    {
        l = new LinkedList();
        l.insertAll(1,2,3,3,3,2,1);
        System.out.println("Created LinkedList "+l);
    }
    static boolean isPalindrome()
    {
        /*Approach 1: Put all the data of Linked List in the Stack. Traverse the list again and pop element if matched
        Approach 2:
        * */
        buildPalindromicLinkedList();
        LLNode fastptr=l.head,mid=l.head;
        Stack<Integer> stack = new Stack<>();
        while(fastptr!=null && fastptr.next !=null)
        {
            fastptr=fastptr.next.next;
            mid=mid.next;
        }
        LLNode temp=mid;
        while(temp!=null)
        {
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=l.head;
        while(temp!=mid)
        {
            if(stack.peek() != temp.data)
                return false;
            stack.pop();
            temp=temp.next;

        }
        if(stack.size()>1)
            return false;
        return true;
    }
    static void deleteDuplicatesFromSortedLinkedList()
    {
        l = new LinkedList();
        l.insertAll(1,1,2,2,2,2,3,3,3,3,3,4,4,4,5);
        System.out.println("Created LinkedList "+l);
        LLNode temp = l.head;
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
    public void deleteDuplicatesFromUnsortedLinkedList()
    {
        /*
        * METHOD 1 (Using two loops)
        Outer loop is used to pick the elements one by one and inner loop compares the picked element with rest of the elements.
        METHOD 2 (Use Sorting)
        In general, Merge Sort is the best-suited sorting algorithm for sorting linked lists efficiently.
        METHOD 3 (Use HashSet)
        */
    }
    static void swap2Nodes(int x, int y)
    {
        buildLinkedList();
        if(x == y)
            return;
        else
        {
            LLNode temp=l.head;
            LLNode prev = null,prevX=null,prevY=null;
            LLNode X=null,Y=null;
            while(temp!=null)
            {
                if(temp.data==x)
                {
                    prevX=prev;
                    X=temp;
                    System.out.println("Found X"+X+" Prev-" + prevX);
                }
                if(temp.data==y)
                {
                    prevY=prev;
                    Y=temp;
                    System.out.println("Found Y" +Y +"Prev-" + prevY);
                }
                prev=temp;
                temp=temp.next;
            }
            LLNode nextX=X.next;
            X.next=Y.next;
            if(prevY !=null)
                prevY.next=X;
            Y.next=nextX;
            if(prevX != null)
                prevX.next=Y;
            if(l.head==X)
                l.head=Y;
            if(l.head==Y)
                l.head=X;
            System.out.println("After Swap "+l);
        }

    }
    public static void main(String[] args) {
        swap2Nodes(2,1);
    }
}
