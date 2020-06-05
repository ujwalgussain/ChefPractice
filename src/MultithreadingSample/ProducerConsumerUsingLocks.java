package MultithreadingSample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Q1{
    int data;
    boolean valueSet;
    ReentrantLock lock=new ReentrantLock();
    Condition producer=lock.newCondition();
    Condition consumer=lock.newCondition();
    void put(int i)
    {
        lock.lock();
        try {
            while (valueSet) {
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data=i;
            System.out.println("Produced data"+i);
            valueSet=true;
            consumer.signal();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    void get()
    {
        lock.lock();
        try {
            while(!valueSet)
            {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumed "+ data);
            valueSet=false;
            producer.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
public class ProducerConsumerUsingLocks {
    public static void main(String[] args) {
        Q1 q = new Q1();
        new Thread(()->{
            for(int i=0;i<10;i++)
                q.put(i);
        }).start();

        new Thread(()->{
            for(;;)
                q.get();
        }).start();
    }
}
