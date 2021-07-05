import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Stream;


class RawMembership{
    List<Policy> policies;
    public RawMembership()
    {

    }
    public RawMembership(List<Policy> policies) {
        this.policies = policies;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }
}
class Policy{
    int id;

    public Policy(int id) {
        this.id = id;
    }
}
public class TestClass {


    public static void main(String[] args) {
        RawMembership rawMembership = new RawMembership(Arrays.asList(new Policy(123),new Policy(234)));
        System.out.println(Optional.ofNullable(rawMembership).map(RawMembership::getPolicies).orElseThrow(RuntimeException::new));
        rawMembership = new RawMembership();
        System.out.println(Optional.ofNullable(rawMembership).map(RawMembership::getPolicies).orElseThrow(RuntimeException::new));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int inc = 0, exc = 0;

        Function<Integer,Integer> getTotalNoOfSubArrays = (n) -> (n * (n-1))/2;
        int res = 0;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i] > right)
            {
                res += getTotalNoOfSubArrays.apply(inc) - getTotalNoOfSubArrays.apply(exc);
                inc = 0;
                exc = 0;
            }
            else if(nums[i] < left)
            {
                exc ++; inc ++;
            }
            else
            {
                res -= getTotalNoOfSubArrays.apply(exc);
                exc=0;
                inc++;
            }
        }
        res += getTotalNoOfSubArrays.apply(inc)- getTotalNoOfSubArrays.apply(exc);

        return res;
    }



}

