package ThreadsPractice;

public class WaitNotifyExample {
    /*
    * Thread which is Expecting Updation calls wait()
    * Thread which performs update calls Notify()*/
    StringBuilder sb = new StringBuilder();
    class T1 extends Thread{
        int total=0;
        T1()
        {
            start();
        }
        public void run()
        {
            System.out.println("Started Child Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this)
            {
                for(int i=1;i<=100;i++)
                {
                    total+=i;
                }
                this.notify();
                System.out.println("Child Thread Notify");
            }
        }
    }
    public static void main(String a[]) throws InterruptedException {
        System.out.println("Started Main Thread");
        T1 t1= new WaitNotifyExample().new T1();
        synchronized (t1)
        {
            System.out.println("Main Thread Waiting");
            t1.wait();
        }
        System.out.println("Main Thread Resumed");
        System.out.println(t1.total);
    }
}
