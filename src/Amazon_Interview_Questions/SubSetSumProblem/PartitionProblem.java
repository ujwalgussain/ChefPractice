package Amazon_Interview_Questions.SubSetSumProblem;

public class PartitionProblem {
    static boolean isPartitionPossible(int a[],int K)
    {
        int total = 0;
        for (int x:
             a) {
            total+=x;
        }
        if(total%K!=0)
        {
            return false;
        }
        return SubsetSumProblemDynamicProg.solveUsingDP(a,total/K);
    }
    public static void main(String[] args) {
        int K=4;
        int a[] = {2,6};
        System.out.println(isPartitionPossible(a,K));
    }
}
