package a_practiceproblems.stacks;

import a_practiceproblems.linkedlistproblems.dll.DLLNode;

public class FindMiddleInStack {
//Logic : While inserting if len is odd the go left by one elem,
    //      While deleting if len is even then go right by one elem

    int count;
    DLLNode head;
    DLLNode mid;

    void push(int ele) {
        DLLNode node = new DLLNode(ele);
        node.next = head;
        count++;
        if (count == 1)
            mid = node;
        else {
            head.prev = node;
            //If len is odd
            if ((count & 1) == 1)
                mid = mid.prev;
        }
        head = node;
        System.out.println("Inserted " + ele);
    }

    DLLNode pop() {
        if (head == null)
            throw new RuntimeException("Stack is Empty");
        DLLNode poppedNode = head;
        head = head.next;
        poppedNode.next = null;
        head.prev = null;
        //If len is even
        if ((count & 1) == 0)
            mid = mid.next;
        return poppedNode;
    }

    void display() {
        System.out.println(head.data + "<- HEAD");
        DLLNode temp = head.next;
        while (temp != null) {
            if (mid == temp)
                System.out.println(temp.data + " <- MID");
            else
                System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        FindMiddleInStack stack = new FindMiddleInStack();
        stack.push(1);
        stack.display();
        stack.push(2);
        stack.display();
        stack.push(3);
        stack.display();
        stack.push(4);
        stack.push(5);
        stack.display();
    }
}
