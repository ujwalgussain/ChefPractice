package ChefProblems.src;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class Test1 {

    public int maximumGap(final List<Integer> A) {
        if (A.size() < 2)
            return 0;
        int len = A.size();
        Comparator<Integer> c = Comparator.naturalOrder();
        int min = A.stream().min(c).get();
        int max = A.stream().max(c).get();

        int interval = (int) Math.ceil((min + max + 0.0) / len - 1);  ///formula : to get interval between consecutive n-1 buckets between
        int bucket_min[] = new int[len - 1];
        int bucket_max[] = new int[len - 1];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);

        for (int element : A) {
            if (element != min && element != max) {
                int idx = (element - min) / interval; //formula : to find the idx of bucket
                bucket_min[idx] = Math.min(bucket_min[idx], element);
                bucket_max[idx] = Math.max(bucket_max[idx], element);
            }
        }
        int maxGap = 0;
        int prev = min;
        //We can find the max difference only with bucket_min[i] - bucket_max[i-1]
        //First we need to consider min as it is not present in any bucket ie., bucket_min[0]-min
        //At Last we need to consider max as it is not present in any bucket  ie., max - bucket_max[lastIdx]
        for (int i = 0; i < len - 1; i++) {
            if (bucket_max[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, bucket_min[i] - min);
            prev = bucket_max[i];
        }
        maxGap = Math.max(maxGap, max - prev);
        return maxGap;
    }

    public static void main(String... a) {
        /*CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 exe");
        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("Error");
        });
        future.get();
        future1.get();*/
        /*CompletableFuture all = CompletableFuture.anyOf(
                CompletableFuture.runAsync(
                () -> {
                    try {
                        System.out.println("T1 start");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //throw new RuntimeException("Error T1");
                    System.out.println("T1 ended");
                }),
                CompletableFuture.runAsync(
                        () -> {
                    System.out.println("T2 start");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T2 exe");
                })
        );
        try {
            all.get();
        } catch (Exception ex){
            System.out.println("exception " + ex);
        }*/
        CountDownLatch downLatch = new CountDownLatch(2);
        CompletableFuture.runAsync(
                () -> {
                    try {
                        System.out.println("T1 start");
                        Thread.sleep(1000);
                        throw new RuntimeException("Error T1");
                        //System.out.println("T1 ended");
                    } catch (Exception e) {
                        System.out.println("T1 blew with " + e);
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();

                    }

                }).exceptionally(ex -> {throw new RuntimeException("Error");});
        CompletableFuture.runAsync(
                () -> {
                    System.out.println("T2 start");
                    try {
                        Thread.sleep(4000);
                        System.out.println("T2 exe");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                });
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main ended");
    }

    public static CompletableFuture<Object> handle(CompletableFuture<Void>... futures) {
        // Complete when ALL the underlying futures are completed
        CompletableFuture<Void> allComplete = CompletableFuture.allOf(futures);

        // Complete when ANY of the underlying futures are exceptional
        CompletableFuture<Void> anyException = new CompletableFuture<>();
        for (CompletableFuture<?> completableFuture : futures) {
            completableFuture.exceptionally((t) -> {
                anyException.completeExceptionally(t);
                return null;
            });
        }

        // Complete when either of the above are satisfied
        return CompletableFuture.anyOf(allComplete, anyException);
    }
}
