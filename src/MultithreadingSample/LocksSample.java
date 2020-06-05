package MultithreadingSample;

import java.util.concurrent.locks.ReentrantLock;

class SharedClass
{
    ReentrantLock lock = new ReentrantLock();
    public void m1()
    {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" m1 called");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
    public void m2()
    {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" m2 called");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
public class LocksSample {
    public static void main(String args[])
    {
        SharedClass s = new SharedClass();
        new Thread(()->{
            s.m1();
        },"T1").start();
        new Thread(()->{
            s.m2();
        },"T2").start();
    }
}
