package a_practiceproblems.linkedlistproblems;

public enum LinkedListUtils{
    /*NORMAL{
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,4,5,6);
            System.out.println("Created LinkedList "+l);
            return l;
        }
    },
    LOOPED{
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,4,5,6);
            LLNode temp=l.head;
            while(temp.next!=null) {
                temp = temp.next;
            }

            LLNode n = new LLNode(7);
            temp.next=n;
            n.next = l.head.next.next;
            return l;
        }
    },
    PALINDROMIC{
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,3,3,2,1);
            System.out.println("Created LinkedList "+l);
            return l;
        }
    };
    public abstract LinkedList buildAndReturn();*/
    NORMAL{
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,4,5,6);
            return l;
        }
    },
    LOOPED{
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,4,5,6);
            LLNode temp=l.head;
            while(temp.next!=null) {
                temp = temp.next;
            }

            LLNode n = new LLNode(7);
            temp.next=n;
            n.next = l.head.next.next;
            return l;
        }
    },
    PALINDROMIC(){
        @Override
        public LinkedList buildAndReturn() {
            LinkedList l = new LinkedList();
            l.insertAll(1,2,3,3,3,2,1);
            return l;
        }
    };
    private LinkedList list;
    LinkedListUtils()
    {
        this.list=buildAndReturn();
    }
    public abstract LinkedList buildAndReturn();

}
