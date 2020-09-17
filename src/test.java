import java.util.Scanner;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Name of the class has to be "Main" only if the class is public. */
class test
{
    Integer i;
    boolean flag;
    synchronized void consume()
    {
        while(!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\tConsumed "+ i);
        flag=false;
        notify();
    }
    synchronized void produce(int x)
    {
        while(flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.i=x;
        System.out.println("Produced "+ i);
        flag=true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        /*test t = new test();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                t.produce(i);
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<10;i++)
            {
                t.consume();
            }


        }).start();*/
        Stream<String> stream = Stream.of("Adarsh","Reena","Kunal","Tendhrall","Amit");
        System.out.println(
                stream.collect(
                        Collectors.toMap(
                                X->X.charAt(0),
                                Function.identity(),
                                (o1, o2) -> o1,
                                () -> new TreeMap<Character,String>()
                                )
                ));
    }
}

