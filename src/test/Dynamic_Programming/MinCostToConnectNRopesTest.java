package Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostToConnectNRopesTest {
    MinCostToConnectNRopes obj = new MinCostToConnectNRopes();
    @Test
    public void test(){
        long input[] = {4, 3, 2, 6};
        long actual = obj.minCost(input,4);
        assertEquals(29,actual);
    }
}