package a_practiceproblems.linkedlistproblems;

import a_practiceproblems.TestClass3;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode createList(int... val) {
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
}
