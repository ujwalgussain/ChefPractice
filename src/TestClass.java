import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TestClass {
    public int dfs(int i, String s, int[] dp, int n) {
        if (dp[i] != 0)
            return dp[i];
        char c = s.charAt(i);
        if (c == '0')
            return 0;
        int res = dfs(i + 1, s, dp, n);
        if (i + 1 < n && (c == '0' ||
                        (c=='2' && Arrays.asList('0', '1', '2', '3', '4', '5', '6').contains(s.charAt(i + 1)))))
            res += dfs(i + 1, s, dp, n);
        dp[i] = res;
        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            int[] freq = new int[26];
            for(char c : s.toCharArray())
                freq[c-'a']++;
            String key = Arrays.toString(freq);
            System.out.println(key);
            map.compute(key, (s1, strings) -> {
                if(strings==null)
                    return new ArrayList<String>(){{add(s);}};
                strings.add(s);
                return strings;
            });
        }
        return new ArrayList<>(map.values());
    }
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        if(arr == null || n ==0) return 0;

        int i = 0;
        int j = m-1;
        int row = -1;

        while(i<n && j>=0){
            if(arr[i][j] == 1 ){
                row = i;
                j--;
            }
            else{
                i++;
            }
        }
        return row;
    }
    /*
    This logic is based on:
        any value i we would need minValue of i-coins[j] where 0<j<coins.length
    Ref :  vector<pair<int, int="">>dp(N + 1);
        dp[0] = {0, 0};
        for (int i = 1; i <= N; i++) {
            int mn = INT_MAX;
            int last;
            for (int j = 0; j < coins.size(); j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]].first < mn) {
                        mn = dp[i - coins[j]].first;
                        last = i - coins[j];
                    }
                }
            }

            dp[i] = {mn + 1, last};
        }
        vector<int> ans;
        pair<int, int=""> cur = dp[N];
        while (cur.first != 0) {
            ans.push_back(N - cur.second);
            N = cur.second;
            cur = dp[cur.second];
        }
        reverse(ans.begin(), ans.end());
        return ans;
     */

    public ArrayList<Integer> plusOne(ArrayList<Integer> B){
        int n = B.size();
        int carry=0;
        Stack<Integer> stack = new Stack<>();
        if(B.get(n-1)==9)
        {
            stack.push(0);
            carry = 1;
        }
        else{
            stack.push(B.get(n-1)+1);
        }
        for(int i=n-2;i>=0;i--)
        {
            if(carry==1)
            {
                if(B.get(i)==9)
                {
                    stack.push(0);
                    carry = 1;
                }
                else
                {
                    stack.push(B.get(i)+1);
                    carry=0;
                }
            }
            else
            {
                stack.push(B.get(i));
            }
        }
        if(carry==1)
            stack.push(1);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty() && stack.peek()==0)
            stack.pop();
        while(!stack.isEmpty())
            ans.add(stack.pop());
        return ans;
    }
    enum test{A};
    public static void main(String[] args) {
        //.out.println(LocalDateTime.now().toLocalDate());
        //System.out.println(new TestClass().plusOne(asList(0,9,9)));
        //System.out.println(Optional.ofNullable("a").map(x->null).orElseThrow(RuntimeException::new));
        System.out.println("".isBlank());
    }
    public static <T> ArrayList<T> asList(T... values) {
        ArrayList<T> ans = new ArrayList<>();
        for (T t : values)
            ans.add(t);
        return ans;
    }
}

