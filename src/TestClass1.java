// Java program to find length
// of the shortest chain
// transformation from source
// to target

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

class TestClass1 {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum=0,start=0,end=0,cnt=0;
        while(end<n)
        {
            while(end<n && sum<=k)
            {
                sum+=nums[end++];
            }
            if(sum==k)
                cnt++;
            while(start<end && sum>k)
            {
                sum-=nums[start++];
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        //System.out.println(hotel(asList(1,2,3),asList(2,3,4),1));
       /* System.out.println(ZonedDateTime.now(Clock.systemDefaultZone()).withZoneSameInstant(ZoneId.of("America/Chicago")));
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
        System.out.println(time);
       ///ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        System.out.println(time.toLocalDateTime());*/
        //Clock.fixed(LocalDateTime.of(2020,2,1,11,00,00).toInstant(ZoneId.systemDefault()))
        System.out.println(subarraySum(new int[]{-1,-1,1},0));
    }

    public static <T> ArrayList<T> asList(T... values) {
        ArrayList<T> ans = new ArrayList<>();
        for (T t : values)
            ans.add(t);
        return ans;
    }

}

