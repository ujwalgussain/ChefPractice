package a_practiceproblems.linkedlistproblems;

public class LLNode {
        public int data;
        public a_practiceproblems.linkedlistproblems.LLNode next;
        LLNode(int i)
        {
            data=i;
        }

        @Override
        public String toString() {
            return data+"";
        }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}