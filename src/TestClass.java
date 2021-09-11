import java.util.*;


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



    //TLE...!!
    static List<Integer> minPartition(int N)
    {
        // code here
        int[] dp = new int[N+1];
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        List[] answer = new ArrayList[N+1];
        for(int coin: coins)
        {
            if(coin==N)
                return new ArrayList(){{add(coin);}};
            if(coin<N){
                dp[coin] = 1;
                answer[coin] = new ArrayList(){{add(coin);}};
            }
            else
                break;
        }
        for(int i=3;i<=N;i++)
        {
            if(dp[i]==1)
                continue;
            int min_val = Integer.MAX_VALUE;
            List<Integer> ans =null;
            for(int j=i-1;j>=i-j;j--)
            {
                int coins_req =dp[j] + dp[i-j];
                if(min_val>coins_req){
                    min_val = coins_req;
                    ans = new ArrayList<>();
                    ans.addAll(answer[i-j]);
                    ans.addAll(answer[j]);
                }
            }
            dp[i] = min_val;
            answer[i] = ans;
        }
        return answer[N];
    }
    public static void main(String[] args) {
        System.out.println(new TestClass().rowWithMax1s(
                new int[][] {{0,0,1,1},{1,0,0,0},{0,1,0,0}},3,4
        ));
    }
}

