import ChefProblems.src.Test;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Stream;


public class TestClass {
    static List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args)  {
        /* System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));*/
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Med Thread - "+ Thread.currentThread().getId());
            return callAem("med", 7000);
        }).thenAcceptAsync(s ->
        {
            System.out.println("Med Thread Received Response");
            add(s);
            countDown(countDownLatch);
        });
        CompletableFuture<String> c3Rs = CompletableFuture.supplyAsync(() -> {
            System.out.println("C3 Thread - "+ Thread.currentThread().getId());
            return callC3Api();
        });
        String c3RsStr = null;
        try {
            c3RsStr = c3Rs.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        countDown(countDownLatch);
        if (c3RsStr != null) {
            CompletableFuture.supplyAsync(() -> {
                System.out.println("VV Thread - "+ Thread.currentThread().getId());
                return callAem("vv", 5000);
            }).thenAccept(s ->
            {
                System.out.println("VV Thread Received Response");
                add(s);
                countDown(countDownLatch);
            });
            CompletableFuture.supplyAsync(() -> {
                System.out.println("24NL Thread - "+ Thread.currentThread().getId());
                return callAem("24nl", 1000);
            }).thenAccept(s ->
            {
                add(s);
                countDown(countDownLatch);
            });
        }
        try {
            System.out.println("Count Down Latch Waiting");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final List " + list);
    }
    static void countDown(CountDownLatch cd)
    {
        cd.countDown();
        System.out.println("cd count "+ cd.getCount());
    }
    static void add(String s) {
        list.add(s);
        System.out.println(list);
    }

    static String callC3Api() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "c3 response";
    }

    static String callAem(String c, long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //Once Sorted we will know
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int ans = nums[i] + nums[l] + nums[r];
                if (ans == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else {
                    if (ans > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return list;
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (String s : strs)
            len = Math.min(len, s.length());
        String prefix = "";
        out:
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c)
                    break out;
            }
            prefix += c;
        }
        return prefix;
    }
}

