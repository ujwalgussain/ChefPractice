package MultithreadingSample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocksSample {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    ArrayList<Integer> l=new ArrayList<>();
    public List<Integer> read()
    {
        readLock.lock();
        ArrayList x = l;
        readLock.unlock();
        return x;
    }
    public void write(int x)
    {
        writeLock.lock();
        try {
            l.add(x);
        }
        finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLocksSample r1 = new ReadWriteLocksSample();
        ExecutorService ex = Executors.newFixedThreadPool(3);
        BigInteger x = BigInteger.valueOf(10);
        for(int i=0;i<4;i++)
        {
            ex.submit(new Thread(()->{
                int d =(int)Math.random();
                r1.write(d);
                System.out.println(Thread.currentThread().getName()+" wrote "+ (d));
            },"Writer "+((char)'A'+i)));
        }
        for(int i=0;i<4;i++)
        {
            ex.submit(new Thread(()->{
                List<Integer> l = r1.read();
                System.out.println(Thread.currentThread().getName()+" read "+l);
            },"Reader "+((char)'A'+i)));
        }

    }

}
