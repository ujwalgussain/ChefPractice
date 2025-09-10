package a_practiceproblems.TreeProblems.tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class AncestorTreeBuilder {
    // https://www.geeksforgeeks.org/dsa/construct-tree-from-ancestor-matrix/
    // Build tree from ancestor matrix
    public static Node buildTreeFromAncestorMatrix(List<List<Integer>> matrix) {
        int n = matrix.size();
        boolean[] parentAssigned = new boolean[n];
        Node[] nodes = new Node[n];

        // Map: sum of ancestors -> list of node indices
        TreeMap<Integer, List<Integer>> sumToNodesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix.get(i).get(j);
            }
            sumToNodesMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        Node root = null;

        for (List<Integer> nodeIndices : sumToNodesMap.values()) {
            for (int nodeIndex : nodeIndices) {
                // Create node if it doesn't exist
                if (nodes[nodeIndex] == null) {
                    nodes[nodeIndex] = new Node(nodeIndex);
                }
                Node current = nodes[nodeIndex];
                root = current;

                // Assign current as parent to its children
                for (int i = 0; i < n; i++) {
                    if (matrix.get(nodeIndex).get(i) == 1 && !parentAssigned[i]) {
                        if (nodes[i] == null) {
                            nodes[i] = new Node(i);
                        }

                        Node child = nodes[i];
                        if (current.left == null) {
                            current.left = child;
                        } else {
                            current.right = child;
                        }
                        parentAssigned[i] = true;
                    }
                }
            }
        }

        return root;
    }

    // In-order traversal for verification
    public static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 0, 0, 0, 0, 0),
                Arrays.asList(1, 0, 0, 0, 1, 0),
                Arrays.asList(0, 0, 0, 1, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 1, 1, 0)
        );

        Node root = buildTreeFromAncestorMatrix(matrix);
        System.out.print("Inorder Traversal: ");
        printInorder(root);
    }
}

