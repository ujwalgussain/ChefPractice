package MultithreadingSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomerThread extends Thread{
    static volatile Integer custId=0;
    static ThreadLocal tl = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return ++custId;
        }
    };
    CustomerThread(String name)
    {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ID = "+tl.get());
    }
}
public class ThreadLocalSample2 {
    public static void main(String[] args) {
        new CustomerThread("t1").start();
        new CustomerThread("t2").start();
        new CustomerThread("t3").start();
        new CustomerThread("t4").start();
    }

}
