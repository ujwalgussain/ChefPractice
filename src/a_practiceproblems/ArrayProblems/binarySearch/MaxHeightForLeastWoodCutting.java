package a_practiceproblems.ArrayProblems.binarySearch;

public class MaxHeightForLeastWoodCutting {
    //https://www.interviewbit.com/problems/woodcutting-made-easy/

       /*
       Input : A = [20, 15, 10, 17] tree heights
                B = 7 -> min wood cut
       We need to determine max cut height
                20  15  10  7
        cut-ht                  wood cut
        19      1   0   0   0   1
        18      2   0   0   0   2
        17      3   0   0   0   3
        16      4   0   0   1   5
        15      5   0   0   2   7 <----This is the ans. We get
        14      6   1   0   3   10
        We need minimum wood cut for max cut-height.
        Hence staring from 0 to 20(max ht in array) we can search maxht that can be acheieved
 */
}
