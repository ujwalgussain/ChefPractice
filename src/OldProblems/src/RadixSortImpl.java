package OldProblems.src;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Task implements Runnable{
    CyclicBarrier c;int i=0;
    Task(CyclicBarrier c){
        this.c = c;
    }
    @Override
    public void run() {
        i++;
        String name = Thread.currentThread().getName();
        System.out.println("Reached Barrier Thread " + name);
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("\tAfter Barrier " + name +" " + i);
    }
}

public class RadixSortImpl {
    static public void main(String... args)
    {
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        int i=-1;
    CyclicBarrier c = new CyclicBarrier(4);
//        while(++i<5)
//        {
//            es.submit(new Task(c));
//        }
//        es.shutdown();
        for(int i = 0;i<5;i++)
        {
            new Thread(new Task(c)).start();

        }
    }

}
