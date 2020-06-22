package MultithreadingSample;

import java.util.Vector;

public class VectorSynchDisadvCheck {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        Runnable r = ()->{
            int i=1;
            while(i<=3)
            {
                int attempts=0;
                    if(!v.contains(i)) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        v.add(i);
                        System.out.println(Thread.currentThread().getName() + " added " + i);
                    }i++;
            }
            System.out.println(Thread.currentThread().getName()+" printed "+ v);
        };
        new Thread(r,"T1").start();
        new Thread(r,"T2").start();

    }
}
