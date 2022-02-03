package Dynamic_Programming.stockspan;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellAnyNoOfTimes {
    int stockBuySell(int A[], int n) {
        // code here
        int maxProfit = 0;
        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (A[i] >= A[i + 1]))
                i++;
            if (i == n - 1)
                break;
            int buy = i++;
            while ((i < n) && (A[i - 1] <= A[i]))
                i++;
            maxProfit+=(A[i - 1]-A[buy]);
        }
        return maxProfit;
    }
}
