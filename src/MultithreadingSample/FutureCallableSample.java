package MultithreadingSample;

import java.util.concurrent.*;

public class FutureCallableSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future f = es.submit(new Callable<String>(){

            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Hello World";
            }
        });
        System.out.println(f.get());
        es.shutdown();
    }
}
