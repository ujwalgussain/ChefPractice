package Dynamic_Programming.udemy;

public class RodCutProblemImpl {
    /*
    Consider rod of len = 4
    Possibilities :
        Case 1 ->	1 + 1 + 1 + 1


        Case 2 ->	1 + 1 +   2
        Case 3 ->	1 +    3

        Case 4 ->	2 + 1 + 1
        Case 5 ->	2 + 2

        Case 6 ->	3 + 1
    ans will be max of these cases.
    If we start from 1 then the max values can be
    so we can tell that ans will be max value of cost[i] + rod[n-i]
    * */

    static int cutRod(int prices[], int n){
        //System.out.print("Call "+n);
        if(n<0){
            //System.out.println("Return 0");
            return 0;
        }
        if(n==0)
        {
            return prices[0];
        }
        int q = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int res = prices[i]+cutRod(prices,n-i-1);
            q = Math.max(q,res);
            //System.out.println("For n = " +n+" [ q="+q+" res=" + res+"]");
        }
        return q;
    }
    //Ref : Udemy Course Dynamic Programming 1
    static int cutRod_dp(int prices[])
    {
        //Assuming that prices[0] = 0 ie., no cost for cutting rod of 0 length
        int n = prices.length;
        int rod[] = new int[n];
        // no cost for cutting rod of 0 length
        rod[0] = 0;
        for(int i=1;i<n;i++)
        {
            //We want to find the maximum value for i where we can earn max profit starting from rod[1]
            //ie., max value of prices[i] + rod [i-j]
            int max_val = Integer.MIN_VALUE;
            for(int j=1;j<=i;j++)
            {
                max_val = Math.max(max_val , prices[j] + rod[i-j]);
            }
            rod[i] = max_val;
        }
        return rod[n-1];
    }
    /*
    Initially
    cost[] 	0 1 5 8
    rod[]   0 0 0 0

    i	j	cost[j]		rod[n-j]	max
    1	1	cost[1]=1	rod[0]=0	1
                                        rod[]	0 1 0 0
    2	1	cost[1]=1	rod[1]=1	1
            cost[2]=5	rod[0]=0	5
                                        rod[]	0 1 5 0
    3 	1 	cost[1]=1	rod[2]=	5   6
        2	cost[2]=5	rod[1]=1	6
        3	cost[3]=8	rod[0]=0	8
                                        rod[]	0 1 5 8
     */

    static int cutRod_dp_returnPossibilities(int prices[])
    {
        int n = prices.length;
        int rod[] = new int[n];
        int possibilities[] = new int[n];
        //base case
        rod[0] = 0;
        possibilities[0] = 1;
        for(int i=1;i<n;i++)
        {
            int max_val = Integer.MIN_VALUE;
            for(int j=1;j<=i;j++)
            {
                int val = prices[j] + rod[i-j];
                if(max_val< val)
                {
                    max_val = val;
                    possibilities[i] = possibilities[i-j];
                }
                //If one more possibility is found
                else if(max_val == val)
                {
                    System.out.printf("%s %s\n",i,i-j);
                    possibilities[i] = possibilities[i] + possibilities[i-j];
                }
            }
        }
        return possibilities[n-1];
    }

    static public void main(String args[])
    {
        System.out.println("Ans " + cutRod(new int[]{1,5,8,9,10,17},6) + "\n");
        System.out.println(cutRod_dp(new int[]{0 ,1,5,8,9,10,17}));
        System.out.println(cutRod_dp_returnPossibilities(new int[]{0 ,1,5,8,9,10,17}));

    }
}
