package MultithreadingSample;

class Q{
    int data=0;
    boolean valueSet=false; //if produced then true
    boolean last=false;
    synchronized void put(int i)
    {
        while(valueSet)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data=i;
        System.out.println("Produced "+i);
        valueSet=true;
        notify();
    }
    synchronized int get()
    {
        while(!valueSet)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got " + data);
        valueSet=false;
        notify();
        return data;
    }

}

public class ProducerConsumerExample {

    public static void main(String args[])
    {
        Q q = new Q();
        Runnable producer = ()->{
            for(int i=1;i<10;i++)
            {
                q.put(i);
            }
            q.last=true;
        };
        Runnable consumer = () -> {
            while(!q.last)
            {
                q.get();
            }
        };
        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
