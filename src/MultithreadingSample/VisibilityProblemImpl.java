package MultithreadingSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VisibilityProblemImpl extends Thread{
    boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        VisibilityProblemImpl t = new VisibilityProblemImpl();
        t.start();
        Thread.sleep(1000);
        t.keepRunning = false;
        System.out.println(System.currentTimeMillis() + ": keepRunning is false");
    }

    public void run() {
        while (keepRunning)
            System.out.println(System.currentTimeMillis() + ": " + keepRunning);
    }
}
