package a_practiceproblems.ArrayProblems;

public class LongestSubArrayWithPositiveProduct {
    static int maxLenSub(int arr[], int N)
    {
        // Stores the length of current subarray with positive product
        int positiveElementsCount = 0;
        // Stores the length of current subarray with negative product
        int negativeElementCount = 0;
        // Stores the length of the longest subarray with positive product
        int result = 0;

        for (int i = 0; i < N; i++)
        {
            if (arr[i] == 0)
                positiveElementsCount = negativeElementCount = 0;
            // If current element is positive
            else if (arr[i] > 0)
            {
                // Increment the length of subarray with positive product
                positiveElementsCount += 1;

                // If at least one element is  present in the subarray with negative product
                if (negativeElementCount != 0)
                    negativeElementCount += 1;
            }

            // If current element is negative
            else
            {
                positiveElementsCount = positiveElementsCount + negativeElementCount;
                negativeElementCount = positiveElementsCount - negativeElementCount;
                positiveElementsCount = positiveElementsCount - negativeElementCount;

                // Increment the length of subarray with negative product
                negativeElementCount += 1;

                // If at least one element is present in the subarray with positive product
                if (positiveElementsCount != 0)
                    positiveElementsCount += 1;

            }
            result = Math.max(result, positiveElementsCount);
        }
        return result;
    }

}
