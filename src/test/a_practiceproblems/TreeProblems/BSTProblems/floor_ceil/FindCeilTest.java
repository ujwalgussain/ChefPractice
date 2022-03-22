package a_practiceproblems.TreeProblems.BSTProblems.floor_ceil;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindCeilTest {

        @Test
        public void test(){
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insertAll(10,5,1,7,15,12,19);
            assertEquals(10,FindCeil.ceilIterative(binarySearchTree.root,10));
            assertEquals(10,FindCeil.ceilIterative(binarySearchTree.root,9));
            assertEquals(19,FindCeil.ceilIterative(binarySearchTree.root,17));
        }
}