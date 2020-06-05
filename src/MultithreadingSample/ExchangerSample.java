package MultithreadingSample;

import java.util.concurrent.Exchanger;

public class ExchangerSample {
    public static void main(String args[])
    {
        Exchanger<String> exch = new Exchanger<>();
        Runnable producer=() ->{
            for (int i=0;i<10;i++)
            {
                try {
                    System.out.println("Produced "+i);
                    exch.exchange(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumer=() ->{
            for (int i=0;i<10;i++)
            {
                try {
                    String j = exch.exchange(new String());
                    System.out.println("Got "+ j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
