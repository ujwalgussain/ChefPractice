package OldProblems.src.KnapSackProblem;

import java.util.Arrays;
import java.util.Comparator;

class Weight{
    int wt, profit;
    Weight(int... a)
    {
        wt = a[0];
        profit=a[1];
    }
    double getRatio()
    {
        return (double)profit/wt;
    }
    public String toString()
    {
        return "w = " + wt  +" Profit = " + profit;
    }
}

public class KnapsackGreedyImpl {

  static int knapsack_greedy(int capacity,Weight[] wts)
  {
      int total = 0, totalProfit = 0;
      int i =0;
      while(true)
      {
          total+=wts[i].wt;
          if(total<=capacity) {
              System.out.println("Selected " + wts[i]);
              totalProfit += wts[i++].profit;
          }
          else
              break;
      }
      System.out.println("Remaining weight - > " +(total-capacity));
      return totalProfit;
  }
    public static void main(String args[])
    {
        Weight wt[] = new Weight[]{new Weight(10,600),new Weight(20,1000),new Weight(30,400)};
        Arrays.sort(wt, new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return -Double.compare(o1.getRatio(),o2.getRatio());
            }
        });
        System.out.println("Total Profit " + knapsack_greedy(50,wt));

    }
}
