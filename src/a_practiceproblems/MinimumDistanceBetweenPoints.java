package a_practiceproblems;

public class MinimumDistanceBetweenPoints {
    /*
In a infinite grid find min moves required to reach from Point A to B.
Note that because the order of covering the points is already defined,
* the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).

Note that what only matters is X = abs(A-C) and Y = abs(B-D).

While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.
When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.

In other words, the total number of steps would correspond to max(X, Y).
*/
    int findMinMovesToReach(int x1, int y1, int x2, int y2) {
        //Allowed to move in 8 directions
        int X = Math.abs(x1 - x2);
        int Y = Math.abs(y1 - y2);
        if (X == 0)
            return Y;
        if (Y == 0)
            return X;
        return Math.max(X, Y);
    }
}
