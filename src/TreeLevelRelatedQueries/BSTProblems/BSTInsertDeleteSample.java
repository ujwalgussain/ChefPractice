package TreeLevelRelatedQueries.BSTProblems;

public class BSTInsertDeleteSample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertAll(10,5,15,18,16,19,3,7,1,4,14);
        tree.display(Traversal.LEVELORDER);
        tree.delete(15);
        tree.display(Traversal.LEVELORDER);
    }
}
