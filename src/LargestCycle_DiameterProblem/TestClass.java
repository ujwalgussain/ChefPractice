package LargestCycle_DiameterProblem;

import java.util.*;
import java.util.stream.Collectors;


/*The Logic is to first find the deepest node in the graph.
 * Then from the DeepestNode find the other deepest node*/

public class TestClass {


    public List<String> findWords(char[][] board, String[] words) {
        class Cell {
            int i, j;

            public Cell(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        //Step 1: Store all cell[i,j] for every character in board [Parsing the board again and again]
        HashMap<Character, List<Cell>> cellMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Cell c = new Cell(i, j);
                cellMap.compute(board[i][j], (key, value) -> {
                    if (value == null)
                        value = new ArrayList<>();
                    value.add(c);
                    return value;
                });
            }
        }

        List<String> ans = new ArrayList<>();
        //Step 2: For Each Word, Start from all cell values having starting char of Word
        for (String word :
                words) {
            for (Cell cell :
                    cellMap.getOrDefault(word.charAt(0), new ArrayList<>())) {
                if (doesBoardContainsWord(board, cell.i, cell.j, word, 0)) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

    public boolean doesBoardContainsWord(char[][] board, int i, int j, String word, int wordIdx) {
        if (wordIdx == word.length())
            return true;
        //out of range
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        char c = board[i][j];
        //already visited
        if (c == '*')
            return false;
        //mark visited
        board[i][j] = '*';
        boolean ans = c == word.charAt(wordIdx)
                && (
                doesBoardContainsWord(board, i - 1, j, word, wordIdx + 1) ||
                        doesBoardContainsWord(board, i + 1, j, word, wordIdx + 1) ||
                        doesBoardContainsWord(board, i, j - 1, word, wordIdx + 1) ||
                        doesBoardContainsWord(board, i, j + 1, word, wordIdx + 1)
        );
        board[i][j] = c;
        return ans;
    }

    public int robHousesInRange(int nums[], int from, int to) {
        int len = to - from + 1;
        if (len == 1)
            return nums[from];
        if (len == 2)
            return Math.max(nums[from], nums[to]);
        if (len == 3)
            return Math.max(nums[from] + nums[to], nums[from + 1]);
        int a = 0, b = 0;
        for (int i = from; i <= to; i++) {
            int a_new = Math.max(a, b + nums[i]);
            b = a;
            a = a_new;
        }
        return a;
    }

    public int rob(int[] nums) {
        int lastIdx = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        return Math.max(
                robHousesInRange(nums, 0, lastIdx - 1), //From 1 to n-1
                robHousesInRange(nums, 1, lastIdx) //From 2 to n
        );

    }


    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] chars = (s + "$" + new StringBuilder(s).reverse().toString()).toCharArray();
        int lps[] = new int[chars.length];
        int i = 1;
        int j = 0;
        while (i < chars.length) {
            if (chars[i] == chars[j]) {
                lps[i++] = ++j;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        String s1 = "", s2 = "";
        int x = 0;
        for (char c :
                chars) {
            s1 += "\t" + c;
            s2 += "\t" + lps[x++];
        }
        System.out.println(s1 + "\n" + s2);
        String prefix = new StringBuilder(s.substring(lps[chars.length - 1], s.length())).reverse().toString();
        return prefix + s;
    }


    public boolean isPalindrome(String s, int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i))
                return false;
        }
        return true;
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        generateCombinations(arr, new ArrayList<>(), 0, k, n);
        return null;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void generateCombinations(int[] arr, List<Integer> list, int s, int k, int n) {
        for (int i = s; i < 9; i++) {
            list.add(arr[i]);
            n -= arr[i];
            if (list.size() < k && n >= 0)
                generateCombinations(arr, list, i + 1, k, n);
            if (list.size() == k && n == 0) {
                System.out.println(list);
                ans.add(new ArrayList<>(list));
            }
            n += arr[i];
            list.remove(list.size() - 1);
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2)
            return false;
        if (k == 0)
            return false;
        long lb = 0, ub = 0;

        TreeSet<Long> ts = new TreeSet<Long>();
        ts.add((long) nums[0]);
        Long closestLessThanOrEqual = null;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            //lb....nums[i]....ub
            ub = t + (long) nums[i];
            lb = (long) nums[i] - t;

            closestLessThanOrEqual = ts.floor(Math.max(lb, ub));
            if (closestLessThanOrEqual != null && Math.abs(closestLessThanOrEqual - nums[i]) <= t)
                return true;
            if (ts.size() == k)
                ts.remove((long) nums[left++]);
            ts.add((long) nums[i]);
        }
        return false;
    }


    public int calculate(String s) {
        Stack<Integer> valuesStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                StringBuffer operandStr = new StringBuffer();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    operandStr.append(s.charAt(i++));
                }
                valuesStack.push(Integer.parseInt(operandStr.toString()));
            } else {
                while (!operatorStack.isEmpty() && hasPrecedence(c, operatorStack.peek())) {
                    //System.out.println(valuesStack);
                    valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));
                }
                operatorStack.push(c);
                i++;
            }

        }
        while (!operatorStack.isEmpty()) {
            // System.out.println(valuesStack);
            valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));
        }
        return valuesStack.pop();
    }

    boolean hasPrecedence(char curr, char top) {
        return getPrecedence(curr) > getPrecedence(top) ? false : true;
    }

    int getPrecedence(char op) {
        switch (op) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 0;
        }
        return 0;
    }

    int applyOperator(char operator, int a, int b) {
        System.out.printf("%s %s %s\n", b, operator, a);
        switch (operator) {
            case '*':
                return b * a;
            case '/':
                return b / a;
            case '+':
                return b + a;
            case '-':
                return b - a;
        }
        return 0;
    }

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new
                Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number,
            // push it to stack for numbers
            if (tokens[i] >= '0' &&
                    tokens[i] <= '9') {
                StringBuffer sbuf = new
                        StringBuffer();

                // There may be more than one
                // digits in number
                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.
                        toString()));

                // right now the i points to
                // the character next to the digit,
                // since the for loop also increases
                // the i, we would skip one
                //  token position; we need to
                // decrease the value of i by 1 to
                // correct the offset.
                i--;
            }

            // Current token is an opening brace,
            // push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered,
                // solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() &&
                        hasPrecedence1(tokens[i],
                                ops.peek()))
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));

        // Top of 'values' contains
        // result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence1(
            char curr, char top) {
        if (top == '(' || top == ')')
            return false;
        if ((curr == '*' || curr == '/') &&
                (top == '+' || top == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op,
                              int b, int a) {
        System.out.printf("%s %s %s\n", b, op, a);
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public int solve(String A, String B) {
        int rows = A.length() + 1;
        int cols = B.length() + 1;
        int dp[][] = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                //same -> diag left +1
                //else -> max of top and left
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {

            int mid = l + (r - l) / 2;
            System.out.printf("lo-%s hi-%s mid-%s\n", l, r, mid);
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new TestClass().countVowelSubstrings("aeiouu"));
    }

    public int solve(String A) {
        int len = A.length();
        char[] arr = A.toCharArray();
        int dp[][] = new int[len][len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j)
                    dp[i][i] = 1;
                else {
                    if (arr[i] == arr[j]) {
                        int n = j - i + 1;
                        if (n == 2)
                            dp[j][i] = 2;
                        else
                            dp[j][i] = (2 + dp[j + 1][i - 1]);
                    } else {
                        dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                    }
                }
                max = Math.max(max, dp[j][i]);
            }
        }
        for (int a[] :
                dp) {
            System.out.println(Arrays.toString(a));
        }
        return max;
    }

    int longestSubsequence(String A, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (A.charAt(i) == A.charAt(j))
            return 2 + longestSubsequence(A, i + 1, j - 1);
        int a = longestSubsequence(A, i + 1, j);
        int b = longestSubsequence(A, i, j - 1);
        return Math.max(a, b);
    }

    final HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public int countVowelSubstrings(String word) {
        int len = word.length();
        int start = 0;
        int count = 0;
        /*for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!vowels.contains(c)) {
                count+=count(word.substring(start,i-1));
                start=i+1;
            }
        }*/
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set = new HashSet<>();
            int j = i;
            while (j < len) {
                if (!vowels.contains(word.charAt(j)))
                    break;
                set.add(word.charAt(j));
                if (set.size() == 5)
                    count++;
                j++;
            }
        }
        return count;
    }

    public int count(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length()) {
                if (!vowels.contains(s.charAt(j)))
                    break;
                set.add(s.charAt(j));
                if (set.size() == 5)
                    count++;
            }
        }
        return count;
    }

    public int maximumGap(final List<Integer> A) {
        TreeSet<Integer> treeSet = A.stream().collect(Collectors.toCollection(TreeSet::new));
        return A.stream().map(x -> {
            Integer lower = treeSet.lower(x);
            return lower == null ? -1 : x - lower;
        }).max(Comparator.naturalOrder()).get();
    }

    public int numDistinct(String A, String B) {
        return find(A, B, A.length() - 1, B.length() - 1);
    }

    HashMap<String, Integer> map = new HashMap<>();

    public int find(String A, String B, int i, int j) {
        int result;
        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);
        if (j < 0) {
            result = 1;
        } else if (i < 0) {
            result = 0;
        } else if (A.charAt(i) == A.charAt(j)) {
            result = find(A, B, i - 1, j - 1) + find(A, B, i - 1, j);
        } else {
            result = find(A, B, i - 1, j - 1);
        }
        map.put(key, result);
        return result;
    }

    public int isMatch(final String A, final String B) {
        return isMatch(A, B, 0, 0) ? 1 : 0;
    }

    public boolean isMatch(String A, String B, int i, int j) {
        boolean result;
        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);
        //Pattern is Processed
        if (j == B.length()) {
            result = i == A.length();
        } else if (i == A.length()) { //String is Processed
            while (j < B.length() && B.charAt(j) == '*') {
                j++;
            }
            result = j == B.length(); //Continue any char other than * is found or pattern ends
        } else if (Character.isLetter(B.charAt(j))) {
            while (i<A.length() && j<B.length() && Character.isLetter(B.charAt(j)) ) {
                if(A.charAt(i) != B.charAt(j))
                    return false;
                i++;
                j++;
            }
            result =   isMatch(A, B, i , j);
        } else if (B.charAt(j) == '?') {
            /*while (B.charAt(j) == '?') {
                i++;
                j++;
            }*/
            result = isMatch(A, B, i + 1, j + 1);
        } else {
            result = isMatch(A, B, i + 1, j) || isMatch(A, B, i, j + 1);
        }
        map.put(key, result);
        return result;
    }
}
