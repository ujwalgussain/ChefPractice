package a_practiceproblems.linkedlistproblems;

public enum LinkedListUtils{
    NORMAL{
        @Override
        public LLNode buildAndReturn() {
            return LLNode.createList(1,2,3,4,5,6);
        }
    },
    LOOPED{
        @Override
        public LLNode buildAndReturn() {
        /* 1- 2 - 3- 4- 5- 6
              \           /
               --7--------     */
            LLNode head = LLNode.createList(1,2,3,4,5,6);
            LLNode temp=head;
            while(temp.next!=null) {
                temp = temp.next;
            }

            LLNode n = new LLNode(7);
            temp.next=n;
            n.next = head.next.next;
            return head;
        }
    },
    PALINDROMIC(){
        @Override
        public LLNode buildAndReturn() {
            return LLNode.createList(1,2,3,2,1);
        }
    };
    public abstract LLNode buildAndReturn();

}
