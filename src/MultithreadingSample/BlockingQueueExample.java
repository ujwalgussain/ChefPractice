package MultithreadingSample;

import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;

public class BlockingQueueExample {
    class BlockingQueue{
        LinkedList<Integer> queue  = new LinkedList<>();
        synchronized void produce(int x){
            while(queue.size()>=5){
                try {
                    System.out.println("Producer Waiting");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\tProducer Notify Consumer");
            notify();
            queue.add(x);
            System.out.println("Added "+ x);
        }
        synchronized int consume(){
            while(queue.size()==0){
                try {
                    System.out.println("Consumer Waiting");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int data = queue.poll();
            System.out.println("Consumed "+ data);
            System.out.println("\tConsumer Notify Producer");
            notify();
            return data;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueueExample().new BlockingQueue();
        Thread producer = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                blockingQueue.produce(i);
            }
        });
        Thread consumer = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                int x = blockingQueue.consume();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        producer.start();
    }
}
