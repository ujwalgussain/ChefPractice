package a_practiceproblems;

import a_practiceproblems.linkedlistproblems.LLNode;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass3 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval.start > newInterval.end) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }
        TreeSet<Interval> treeSet = new TreeSet<>((x, y) -> x.start - y.start);
        treeSet.addAll(intervals);
        treeSet.add(newInterval);
        Stack<Interval> stack = new Stack<>();
        stack.add(intervals.get(0));
        for (Interval currInterval : treeSet) {
            Interval top = stack.peek();
            int topEnd = top.end;
            if (topEnd < currInterval.start)
                stack.push(currInterval);
            else
                top.end = Math.max(topEnd, currInterval.start);

        }
        return stack.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int arr[][] = new int[A][A];
        int c = 1;
        int left = 0, right = A - 1;
        int top = left, bottom = A - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0:
                    for (int i = left; i <= right; i++)
                        arr[top][i] = c++;
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++)
                        arr[i][right] = c++;
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--)
                        arr[bottom][i] = c++;
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--)
                        arr[i][left] = c++;
                    left++;
                    break;
            }
            dir = (dir + 1) % 4;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] a : arr) {
            ArrayList<Integer> subres = new ArrayList<>();
            for (int i : a) {
                subres.add(i);
            }
            result.add(subres);
        }
        return result;
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        class Node {
            int elem, i, j;

            public Node(int elem, int i, int j) {
                this.elem = elem;
                this.i = i;
                this.j = j;
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Node(arr[0][i], 0, i));
        }
        while (priorityQueue.peek().elem != Integer.MAX_VALUE) {
            Node curr = priorityQueue.poll();
            ans.add(curr.elem);
            if (curr.j > arr[curr.i].length)
                priorityQueue.add(new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
            else
                priorityQueue.add(new Node(arr[curr.i][curr.j + 1], curr.i, curr.j + 1));
        }
        return ans;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
            }

        }
        return stack.isEmpty();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), new boolean[nums.length]);
        return new ArrayList<>(set);
    }

    ArrayList<List<Integer>> set = new ArrayList<>();

    public void permute(int[] nums, List<Integer> permutation, boolean used[]) {
        if (permutation.size() == nums.length)
            set.add(new ArrayList<>(permutation));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                permutation.add(nums[i]);
                used[i] = true;
                permute(nums, permutation, used);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
    }



    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public String simplifyPath(String A) {
        /*
         * If currStr is . or empty then move ahead
         * If currStr is .. then just pop the top only if it is not empty
         * else push*/
        String[] arr = A.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("") || s.equals("."))
                continue;
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
                continue;
            }
            //This means s is folder name
            stack.push(s);
        }
        return ("/" + stack.stream().collect(Collectors.joining("/")));
    }

    public void setZeroes(int[][] matrix) {

        //optimized,in-place, 0(2*((m*n)) time, space 1
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        rec(new ArrayList<>(), 1, n, k);
        return combinations;
    }

    List<List<Integer>> combinations = new ArrayList<>();

    public void rec(List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            rec(list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets.add(new ArrayList<>());
        generateSubsets(nums, 0, new ArrayList<>());
        return subsets;
    }

    List<List<Integer>> subsets = new ArrayList<>();

    public void generateSubsets(int nums[], int idx, List<Integer> list) {
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            subsets.add(new ArrayList<>(list));
            generateSubsets(nums, i + 1, list);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, new boolean[m][n], word, i, j, m, n, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, boolean vis[][], String word, int i, int j, int rows, int cols, int strIdx) {
        if (strIdx == word.length())
            return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        if (vis[i][j])
            return false;
        if (board[i][j] == word.charAt(strIdx)) {
            vis[i][j] = true;
            boolean ans = solve(board, vis, word, i, j - 1, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i, j + 1, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i + 1, j, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i - 1, j, rows, cols, strIdx + 1);
            vis[i][j] = false;
            return ans;
        }
        return false;
    }

    public int removeDuplicates(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]==nums[i+1] && nums[i]==nums[i+2])
                nums[j++] = nums[i];
        }
        nums[nums.length-2] = nums[j++];
        nums[nums.length-1] = nums[j++];
        return j;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> idxStack = new Stack<>();
        int i=0, maxArea = -1;
        for(;i<heights.length;i++){
            while(!idxStack.isEmpty() && heights[idxStack.peek()]>=heights[i]){
                int pop = idxStack.pop();
                int area = heights[pop] * (idxStack.isEmpty()?i:i-idxStack.peek()-1);
                maxArea = Math.max(maxArea,area);
            }
            idxStack.push(i);
        }
        while(!idxStack.isEmpty()){
            int pop = idxStack.pop();
            int area = heights[pop] * (idxStack.isEmpty()?i:i-idxStack.peek()-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int maximalSquare(char[][] matrix) {
        /*
        Intialize 1st row and 1st col of dp[][]-> If m[i][j]==1 then 1 else 0;

        for i = 1 to rows
            for j=1 to cols
                m[i][j]==1 == 1 then dp[i][j]= 1 + min(top,diag-left, bottom)
        Note the maxValue in dp[][] is size of square
         */
        int m = matrix.length, n = matrix[0].length;
        boolean f = false;
        int dp[][] = new int[m][n];
        //Fill Rows
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]=='1')
            {
                dp[0][i] = 1;
                f = true;
            }else
                dp[0][i] = 0;
        }
        //Fill Cols
        for (int i = 0; i < m; i++) {
           if(matrix[i][0]=='1'){
               f = true;
               dp[i][0] =  1;
            }
           else
               dp[i][0] = 0;
        }
        int ans = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    f=true;
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], //diag left
                            Math.min(
                                    dp[i - 1][j], //top
                                    dp[i][j - 1] //left
                            )
                    );

                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans==0?!f?0:1:ans<<1;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode tail1 = dummy1;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode first = null;
        ListNode prev= dummyhead;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val>=x){
                //move temp to end;
                if(first==null)
                    first=temp;
                prev.next = temp.next;
                temp.next=null;
                tail1.next = temp;
                tail1 = tail1.next;
                temp = prev.next;
            }
            else{
                prev = temp;
                temp=temp.next;
            }
        }
        if(prev==dummyhead){
            return dummy1.next;
        }
        if(tail1!=dummy1){
            prev.next = dummy1.next;
        }
        return dummyhead.next;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i <= 3; i++) {
            int len1 = Math.min(i+3,n);
            for (int j = i+1; j <= len1; j++) {
                int len2 = Math.min(j+3,n);
                for (int k = j+1; k <= len2; k++) {
                    String p1="",p2="",p3="",p4="";
                    if(isValidIp((p1=s.substring(0,i))) && isValidIp((p2=s.substring(i,j))) && isValidIp((p3=s.substring(j,k))) &&isValidIp((p4=s.substring(k))))
                        list.add(p1+"."+p2+"."+p3+"."+p4);
                }
            }
        }
        return list;
    }
    public boolean isValidIp(String s){
        if(s.length()==0 || s.length()>3)
            return false;
        int no = Integer.parseInt(s);
        if(no==0 && s.length()==0)
            return true;
        if(no>0 && no<=255 && s.charAt(0)!='0')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new TestClass3().restoreIpAddresses("101023"));
    }

}
