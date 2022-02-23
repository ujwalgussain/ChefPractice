package a_practiceproblems.TreeProblems.BSTProblems.createBST;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class CheckLOTIsForValidBST {
    //test cases written
    public boolean checkLOTisValid(List<Integer> levelOrderTraversal) {
        class Element{
            int data,min,max;

            public Element(int data, int min, int max) {
                this.data = data;
                this.min = min;
                this.max = max;
            }
        }
        LinkedList<Element> queue = new LinkedList<>();
        int i = 0;
        int n = levelOrderTraversal.size();
        queue.add(new Element(levelOrderTraversal.get(i),Integer.MIN_VALUE,Integer.MAX_VALUE));
        i++;
        while(i<n && !queue.isEmpty()){
            Element curr = queue.poll();
            if(i<n && curr.min<levelOrderTraversal.get(i) && levelOrderTraversal.get(i)<curr.data){
                queue.add(new Element(levelOrderTraversal.get(i),curr.min,curr.data));
                i++;
            }
            if(i<n && curr.data<levelOrderTraversal.get(i) && levelOrderTraversal.get(i)<curr.max){
                queue.add(new Element(levelOrderTraversal.get(i),curr.data,curr.max));
                i++;
            }
        }
        return i==n;
    }
}
