package MultithreadingSample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*Cyclic Barrier will release the held threads as soon as they call await()
* */
public class CyclicBarrierSample2 {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3,()->{
            System.out.println("Barrier Reached");
        });
        Runnable r1=()->
        {
            String name=Thread.currentThread().getName();
            System.out.println(name+" started");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        new Thread(r1,"A").start();
        new Thread(r1,"B").start();
        new Thread(r1,"C").start();
        new Thread(r1,"D").start();
        new Thread(r1,"E").start();
        new Thread(r1,"F").start();


    }
}
