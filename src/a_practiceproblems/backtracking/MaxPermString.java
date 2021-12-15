package a_practiceproblems.backtracking;

public class MaxPermString {
    //Link : https://www.interviewbit.com/problems/maximal-string/
    int max;
    public void permute(String A, int B){
        if(B==0)
            return;
        for(int i=0;i<A.length()-1;i++){
            for (int j = i+1; j < A.length(); j++) {
                if(A.charAt(j)>A.charAt(i)){
                    A = swap(A,i,j);
                    max = Math.max(max,Integer.parseInt(A));
                    permute(A,B-1);
                    A= swap(A,j,i);
                }
            }
        }
    }

    public String swap(String str, int a, int b){
        char arr[] = str.toCharArray();
        char c  = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
        return String.valueOf(arr);
    }
    public String solve(String A, int B) {
        if(B==0)
            return A;
        max = Integer.parseInt(A);
        permute(A,B);
        return String.valueOf(max);

    }
}
