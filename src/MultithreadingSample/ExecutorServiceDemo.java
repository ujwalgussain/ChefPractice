package MultithreadingSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    static Runnable getRunnable()
    {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    static public void main(String args[])
    {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=0;i<20;i++)
        {
            es.execute(getRunnable());
        }
        es.shutdown();
    }
}
