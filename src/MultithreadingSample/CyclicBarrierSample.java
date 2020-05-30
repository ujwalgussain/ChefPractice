package MultithreadingSample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String args[])
    {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runnable r1 = ()->{
            Thread curr = Thread.currentThread();
            System.out.println(curr.getName()+" started");
            try {
                System.out.println(curr.getName()+" reached Barrier");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();

            }
            System.out.println(curr.getName()+" ended");
        };
       /* Runnable r2 = ()->{
            Thread curr = Thread.currentThread();
            System.out.println(curr.getName()+" started");
            try {
                System.out.println(curr.getName()+" reached Barrier");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(curr.getName()+" ended");
        };
        Runnable r3 = ()->{
            Thread curr = Thread.currentThread();
            System.out.println(curr.getName()+" started");
            try {
                System.out.println(curr.getName()+" reached Barrier");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(curr.getName()+" ended");
        };*/
        new Thread(r1,"t1").start();
        new Thread(r1,"t2").start();
        new Thread(r1,"t3").start();
        System.out.println("Main Thread Ended");
    }
}
