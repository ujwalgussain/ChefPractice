package MultithreadingSample;

public class DaemonThreadSample {
    public static void main(String[] args) {
        //JVM will not wait for this thread to end
        Thread t1 = new Thread(()->{
            System.out.println("Daemon Thread -" + Thread.currentThread().getPriority());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread Ended"); //Hence this statement will never be executed\
        });
        t1.setDaemon(true);
        Thread t2 = new Thread(()->{
            System.out.println("User Thread Ended -" + Thread.currentThread().getPriority());
        });
        t1.start();
        t2.start();
    }
}
