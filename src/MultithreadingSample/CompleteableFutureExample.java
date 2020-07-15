package MultithreadingSample;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
class Order{
    int orderID;
    String state;
    Order()
    {
        state="created";
    }

    @Override
    public String toString() {
        return orderID+"-"+state;
    }
}
public class CompleteableFutureExample {
    static int ID=1;
    public Order createOrder()
    {
        Order o = new Order();
        o.orderID=ID++;
        System.out.println(o);
        return o;
    }
    public Order enrichOrder(Order o)
    {
        o.state="enriched Order";
        System.out.println("\t"+o);
        return o;
    }
    public Order payment(Order o)
    {
        o.state="payment Done";
        System.out.println("\t\t"+o);
        return o;
    }

    public static void main(String[] args) {
        CompleteableFutureExample c = new CompleteableFutureExample();
        for(int i=0;i<5;i++)
        {
            CompletableFuture.supplyAsync(() -> c.createOrder())
                    .thenApplyAsync(order -> c.enrichOrder(order))
                    .thenAccept(order -> c.payment(order));
        }

    }
}
