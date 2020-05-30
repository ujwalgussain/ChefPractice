package MultithreadingSample;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch cd = new CountDownLatch(10);
        Runnable r= ()->{
          for(int i=0;i<10;i++) {
              cd.countDown();
              System.out.println("Decremented ");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };

        new Thread(r).start();
        cd.await();
        System.out.println("Main Thread Ended");
    }
}
