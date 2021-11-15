import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class TestClass1 {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static public void display(ListNode head) {
        ListNode temp = head;
        if(head==null)
            System.out.println("null");
        while (temp != null) {
            System.out.printf(temp.val + " ");
            temp = temp.next;
        }
    }

    static ListNode createList(int... val) {
        ListNode head = null;
        ListNode temp = head;
        for (int i : val) {
            if (head == null) {
                head = new ListNode(i);
                temp = head;
            } else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return head;
    }

    public ListNode insertionSortList(ListNode A) {
        ListNode sortedHead = new ListNode(-1); //dummy node
        ListNode curr = A, next = null;
        while (curr != null) {
            next = curr.next;
            //We need these pointers for insertion
            ListNode prevSorted = sortedHead;
            ListNode tempSorted = sortedHead.next;

            while(tempSorted != null) {
                if(tempSorted.val>curr.val)//if we change the sign list will be sorted in descending order.
                    break;
                prevSorted = tempSorted;
                tempSorted = tempSorted.next;
            }
            //either end of list or tempSorted will point the first element greater than curr
            //just change the next pointers to insert
            prevSorted.next = curr;
            curr.next = tempSorted;
            curr = next;
        }
        return sortedHead.next;
    }

    /*public ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;
        ListNode next= null;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(curr!=null) {
            next = curr.next;
            if(curr.next!=null && curr.val== next.val){
                while(next!=null && next.val==curr.val) {
                    next=next.next;
                }
                if(prev==null){

                }
                else
            }
            else{

            }
        }
    }*/

    public ListNode solve(ListNode A) {
        if(A==null || A.next == null || A.next.next==null)
            return A;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr_prev = A, curr_next= null;
        ListNode curr = A.next;
        while(curr!=null){
            curr_next = curr.next;
            curr_prev.next = curr_next;
            curr.next=null;
            stack.push(curr);
            if(curr_next==null)  //even length should stop here
                break;
            curr_prev=curr_next;
            curr = curr_next.next; //odd length should stop here
        }
        ListNode prev = A;
        curr = A;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            //remove curr and add temp
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        return A;
    }

    public static void main(String[] args) {
        //display(new TestClass1().insertionSortList(createList(1,4,3,2,5,2)));
        //System.out.println(new TestClass1().lPalin(createList(1,2,3)));
        display(new TestClass1().solve(createList(1,2)));
    }

    public static <T> ArrayList<T> asList(T... values) {
        ArrayList<T> ans = new ArrayList<>();
        for (T t : values)
            ans.add(t);
        return ans;
    }
}

