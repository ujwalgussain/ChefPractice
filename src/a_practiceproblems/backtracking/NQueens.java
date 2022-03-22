package a_practiceproblems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(5));
    }

    //Queens should not be attacking ie., same row same column or diagonal
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        boolean visited[] = new boolean[n];
        for (char[] r :
                board) {
            Arrays.fill(r, '.');
        }
        dfs(
                board,
                n,
                visited,
                0
        );
        return solutions;
    }

    List<List<String>> solutions = new ArrayList<>();

    public void dfs(char board[][], int n, boolean visited[], int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            //System.out.println("solution");
            Stream.of(board).forEach(r -> {
                        //System.out.println(Arrays.toString(r));
                        solution.add(Stream.of(r).map(x -> String.valueOf(x)).collect(Collectors.joining()));
                    }
            );
            solutions.add(solution);
        } else {
            for (int i = 0; i < n; i++) {
                //same column
                if (!visited[i]) {
                    if (isSafe(board, n, row, i)) {
                        visited[i] = true;
                        board[row][i] = 'Q';
                        dfs(board, n, visited, row + 1);
                        board[row][i] = '.';
                        visited[i] = false;
                    }
                }
            }
        }
    }

    boolean isSafe(char board[][], int n, int row, int column) {
        int i= row-1 , j = column-1;
        //check upper left diagonal
        while(i>=0 && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i=row+1;
        j = column-1;
        //check lower left diagonal
        while(i<n && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
