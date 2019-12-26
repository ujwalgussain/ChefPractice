import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayModificationProblem {
    static void modify(int arr[], long K, int N)
    {
        long i=-1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(++i<K)
        {
            int idx1 = (int)(i%N),idx2=0;
            if(hm.containsKey(idx1))
            {
                idx2 = hm.get(idx1);
            }
            else {
                hm.put(idx1,idx2 =N-idx1-1);
            }
            arr[idx1]^=arr[idx2];
        }
    }
    static void modify1(int arr[], long K, int N)
    {
        long i=-1;
        int idx1=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(++i<K)
        {
            if(idx1==N)
                idx1=0;
            int idx2=0;
            if(hm.containsKey(idx1))
            {
                idx2 = hm.get(idx1);
            }
            else {
                hm.put(idx1,idx2 =N-idx1-1);
            }
            arr[idx1++]^=arr[idx2];
        }
    }
    static public void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testcase = 0;
        if(sc.hasNext())
            testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int N = 0;
            if(sc.hasNext())
                N=sc.nextInt();
            long K =0L;
            if(sc.hasNext())
                K=sc.nextLong();
            int arr[] = new int[N];
            int j = -1;
            while(++j<N)
            {
                if(sc.hasNext())
                    arr[j] = sc.nextInt();
            }
            modify(arr,K,N);
            for (int data:arr) {
                System.out.printf("%d ",data);

            }
        }

    }
}
/*============================PS==============================
* Chef is really interested in the XOR operation.
* He wants to take a sequence A0,A1,…,AN−1 and for each i from 0 to K−1 inclusive (in this order, one by one),
*  perform the following operation:

    Let's denote a=Ai%N and b=AN−(i%N)−1 before this operation.
        Change Ai%N to a⊕b, i.e. a XOR b.
Since Chef is busy, he asked you to find the final sequence he should get after performing these operations.
* nput
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and K.
The second line contains N space-separated integers A0,A1,…,AN−1.
Output
For each test case, print a single line containing N space-separated integers ― the elements of the final sequence.

Constraints
1≤T≤70
1≤N≤104
1≤K≤1012
1≤Ai≤107 for each valid i
Subtasks
Subtask #1 (30 points): 1≤K≤106
Subtask #2 (70 points): original constraints

Example Input
1
2 2
1 2
Example Output
3 1
* */