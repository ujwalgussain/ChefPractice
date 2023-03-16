package a_practiceproblems.TreeProblems;

public class FenwickTree {
    int BITree[] = new int[1000];
    void constructTree(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            updateTree(arr, i);
        }
    }
    void updateTree(int arr[], int i) {
        /*
            For parent = 0 -> [ 1 2 4 8 ]
            For parent = 1 -> [ 2 4 8 ]
            For parent = 2 -> [ 3 4 8 ]
            For parent = 3 -> [ 4 8 ]
            For parent = 4 -> [ 5 6 8 ]
            For parent = 5 -> [ 6 8 ]
            For parent = 6 -> [ 7 8 ]
            For parent = 7 -> [ 8 ]
            For parent = 8 -> [ 9 10 ]
            For parent = 9 -> [ 10 ]
        */
        int index = i+1;
        while(index <= arr.length) {
            BITree[index]+=arr[i];
            index +=(index & (-index)); //Java stores negative numbers in form of 2's complement
        }
    }

    int getSum(int endIdx){
        int index = endIdx + 1;
        int sum = 0;
        while (index > 0) {
            sum += BITree[index];
            index -= (index & (-index));
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        FenwickTree tree = new FenwickTree();
        tree.constructTree(arr);
        System.out.println(tree.getSum(2));
        System.out.println(Integer.toBinaryString(1));
    }
}
