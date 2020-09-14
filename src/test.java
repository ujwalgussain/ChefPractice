import java.util.Scanner;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

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
        test t = new test();
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


        }).start();
    }
}

