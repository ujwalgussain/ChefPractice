package LargestCycle_DiameterProblem;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.*;
import java.util.function.Function;
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

    /*public int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        int dp[][] = new int[rows][cols];
        //add column heights
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (get(A, i, j) != 0)
                    if (i == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = get(A, i, j) + dp[i - 1][j];
            }
        }
        //sort rows
        int maxArea = Integer.MIN_VALUE;
        for (int[] row : dp) {
            Arrays.sort(row);
            for (int i = cols - 1; i >= 0; i--) {
                maxArea = Math.max(maxArea, row[i] * (cols - i));
            }
        }
        return maxArea;
    }
*/
    public int get(ArrayList<ArrayList<Integer>> A, int i, int j) {
        return A.get(i).get(j);
    }


    public int solve(ArrayList<ArrayList<Integer>> A) {
        int houses = A.size();
        int[][] dp = new int[houses][3];
        dp[0][0] = A.get(0).get(0);
        dp[0][1] = A.get(0).get(1);
        dp[0][3] = A.get(0).get(2);
        /*
        So dp[i][0] = A[i][0] + min(dp[i-1][1],dp[i-1][2])
        Similarly:
        dp[i][1] = A[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = A[i][2] + min(dp[i-1][0], dp[i-1][1])
         */
        for (int i = 1; i < houses; i++) {
            dp[i][0] = A.get(i).get(0) // paint curr house red
                    + Math.max(dp[i - 1][1], dp[i - 1][2]); //prev house can be painted green/blue
            dp[i][1] = A.get(i).get(0) // paint curr house green
                    + Math.max(dp[i - 1][0], dp[i - 1][2]); //prev house can be painted red/blue
            dp[i][2] = A.get(i).get(0) // paint curr house blue
                    + Math.max(dp[i - 1][0], dp[i - 1][1]);//prev house can be painted red/green
        }
        return Math.min(dp[houses - 1][0], Math.min(dp[houses - 1][1], dp[houses - 1][2]));
        /*rec(A,0,-1,0);
        return minCost;*/

    }

    int minCost;

    public void rec(ArrayList<ArrayList<Integer>> A, int house, int lastPaint, int cost) {
        if (house == A.size()) {
            minCost = Math.min(minCost, cost);
            return;
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == lastPaint)
                continue;
            rec(A, house + 1, i, cost + A.get(house).get(i));
        }
    }

    public ArrayList<String> reorderLogs(ArrayList<String> A) {
        class Log {
            String id;
            String content;
            boolean isDigitLog;
            String logStr;
            int idx;

            public Log(String logStr, int idx) {
                this.logStr = logStr;
                int i = logStr.indexOf('-');
                id = logStr.substring(0, i);
                content = logStr.substring(i + 1);
                isDigitLog = isDigitLog(content);
                idx = i;
            }
        }
        HashMap<String, Log> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), new Log(A.get(i), i));
        }

        return A.stream().sorted((x, y) -> {
            Log a = map.get(x);
            Log b = map.get(y);
            if (a.isDigitLog) {
                if (b.isDigitLog) {
                    //compare idx
                    return Integer.compare(a.idx, b.idx);
                } else {
                    return -1;
                }
            } else {
                //a is letter log
                if (b.isDigitLog) {
                    return 1;
                } else {
                    if (a.content.equals(b.content))
                        return a.id.compareTo(b.id);
                    else
                        return a.content.compareTo(b.content);
                }
            }
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    boolean isDigitLog(String log) {
        String logStr = log.substring(log.indexOf('-') + 1);
        return logStr.matches("(.)*(\\d)(.)*");
    }

    public int calculateMinimumHP(int[][] dungeon) {
        //Going from 0,0 to n,n will not work with same approach
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    public String FirstNonRepeating(String A) {
        // code here
        char[] arr = A.toCharArray();
        int freq[] = new int[26];
        String answer = "";
        LinkedHashSet<Character> nonRepeatingChars = new LinkedHashSet<>();
        for (char c :
                arr) {
            if (++freq[c - 'a'] > 1) {
                //repeating
                nonRepeatingChars.remove(c);
            } else {
                nonRepeatingChars.add(c);
            }
            answer += nonRepeatingChars.isEmpty() ? "#" : nonRepeatingChars.iterator().next();
        }
        return answer;
    }


    public static void test(String s) {
        /*int len = s.length();
        for(int i=0;i<len;i++){
            for (int j = i; j < len; j++) {
                HashSet<Character> set = new HashSet<>();
                boolean f = false;
                for (int k = i; k <=j ; k++) {
                    if(set.contains(s.charAt(k))) {
                        f = true;
                        break;
                    }
                    set.add(s.charAt(k));
                }
                if(!f)
                    System.out.println(s.substring(i,j+1));
            }
        }*/

        int max = 1, start = 0;
        HashSet<Character> set = new HashSet<>();
        char arr[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(arr[i])) {
                set.remove(arr[start++]);
            }
            int len = i - start + 1;
            max = Math.max(max, len);
            set.add(arr[i]);
        }
        System.out.println(max);
    }


    static Boolean isSubsetSum(int N, int arr[], int sum) {
        int rows = arr.length;
        int cols = sum;
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        for (int currSum = 0; currSum <= rows; currSum++) {
            for (int j = 0; j <= cols; j++) {
                if (currSum == 0) {
                    dp[0][j] = true;
                } else if (j == 0) {
                    dp[currSum][0] = false;
                } else if (arr[j - 1] > currSum) {
                    dp[currSum][j] = dp[currSum][j - 1];
                } else {
                    dp[currSum][j] = dp[currSum][j - 1] || dp[currSum - arr[j - 1]][j];
                }
            }
        }
        return dp[rows][cols];
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num :
                nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();

        }
        return minHeap.peek();
    }


    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int n = s.length();
        int diff = s.length();
        int[] freq = new int[26];
        List<Integer> answer = new ArrayList<>();
        for (char c :
                p.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                //start removing
                if (++freq[s.charAt(i - k) - 'a'] > 0)
                    diff++;
            }
            if (--freq[s.charAt(i)] >= 0)
                diff--;
            if (diff == 0) {
                answer.add(i - k + 1);
            }
        }
        return answer;
    }


    public String longestNiceSubstring(String s) {
        //base case
        if(s.equals(""))
            return "";
        HashSet<Character> set =new HashSet<>();
        s.chars().forEach(c -> set.add((char)c));
        for (int i = 0; i < s.length(); i++) {
            if(!(set.contains(Character.toLowerCase(s.charAt(i))) && set.contains(Character.toUpperCase(s.charAt(i))))){
                String firstHalf = longestNiceSubstring(s.substring(0,i));
                String secondHalf = longestNiceSubstring(s.substring(i+1));
                return firstHalf.length()>=secondHalf.length()?firstHalf : secondHalf;
            }
        }
        return s;
    }
    public int longestSubarray(int[] nums) {
        int start = 0;
        int zeroCnt = 0;
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while(zeroCnt>1){
                if(nums[start]==0)
                    zeroCnt--;
                start++;
            }
            if(nums[i]==0){
                zeroCnt++;
            }
            if(zeroCnt==1){
                maxV = Math.max(maxV,i-start);
            }
        }
        return maxV;
    }

    public static void main(String[] args) {
        System.out.println(new TestClass().nthUglyNumber(7));
    }

    public int nthUglyNumber(int n) {
        List<Integer> uglyNos = new ArrayList<Integer>();
        uglyNos.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        System.out.println("n2\tn3\tn5\ti2\ti3\ti5\tuglyNos");
        while (uglyNos.size()<n){
            int n2 = uglyNos.get(i2) * 2;
            int n3 = uglyNos.get(i3) * 3;
            int n5 = uglyNos.get(i5) * 5;
            int next = Math.min(n2,Math.min(n3,n5));
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%s\t",n2,n3,n5,i2,i3,i5,uglyNos);
            System.out.println("Min = "+next);
            if(next==n2)
                i2++;
            if(next==n3)
                i3++;
            if(next==n5)
                i5++;
            uglyNos.add(next);
        }
        return uglyNos.get(uglyNos.size()-1);
    }
    public int numSquares(int n) {
        /*
        n = 6 -> possible solutions are
        1 + 1 + 1 + 1 + 1 + 1
        1 + 1 + 4
        1 + 4 + 1
        4 + 1 + 1

         */
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                //we Will always enter the loop for j=1
                //if n=10, j*j means find min of dp[10-1], dp[10-4], dp[10-9]
                //Hence at each position we are cons
                minValue = Math.min(minValue,dp[i-(j*j)]);
            }
            dp[i] = minValue+1;
        }
        return dp[n];
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT(1,n);
    }
    public List<TreeNode> allPossibleFBT(int start, int end) {
        if(start>end)
            return List.of(null);
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <=end; i++) {
            List<TreeNode> leftSubtrees = allPossibleFBT(start,i-1);
            List<TreeNode> rightSubTrees = allPossibleFBT(i+1,end);
            for (TreeNode leftSubtree: leftSubtrees) {
                for (TreeNode rightSubtree: rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree;
                    root.right = rightSubtree;
                    result.add(root);
                }

            }
        }
        return result;
    }

}
