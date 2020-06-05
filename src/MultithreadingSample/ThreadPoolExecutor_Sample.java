package MultithreadingSample;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor_Sample {
    public static void main(String args[]) throws InterruptedException {
        //ExecutorService service = Executors.newFixedThreadPool(2);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=1;i<=10;i++)
        {
            service.execute(new ThreadPoolExecutor_Sample().new Task(i));
        }

        service.shutdown();
        synchronized (map)
        {
            map.wait();
        }
        System.out.println(map);

    }
    static HashMap<String,String> map= new HashMap<>();

    class Task implements Runnable{
        int id;
        Task(int i)
        {
            id=i;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = Thread.currentThread().getName();
            //System.out.println(String.format("%s Thread - %s",id, s));
            synchronized (map)
            {
                if(map.containsKey(s))
                {
                    map.put(s,map.get(s)+" "+id);
                }
                else
                {
                    map.put(s,""+id);
                }
                if(id==10)
                {
                    map.notify();
                }
            }
        }
    }
}
