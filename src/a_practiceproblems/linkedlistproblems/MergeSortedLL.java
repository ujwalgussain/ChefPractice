package a_practiceproblems.linkedlistproblems;

public class MergeSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        dummy.next = list1;
        ListNode prev = dummy;
        ListNode t1 = list1, t2 = list2, curr=null, end=null;
        while(t1!=null && t2!=null){
            end = t1;
            if(t1.val>t2.val){
                curr = t2;
                t2 = t2.next;
                curr.next=t1;
                prev.next=curr;
                prev = curr;
            } else{
                prev = t1;
                t1 = t1.next;
            }
        }
        if(t2!=null){
            end.next=t2;
        }
        return dummy.next;
    }
}
