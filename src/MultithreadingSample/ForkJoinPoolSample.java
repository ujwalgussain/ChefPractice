package MultithreadingSample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/*
* ForkJoinPool accepts 2 kind of tasks classes:
*   RecursiveAction : Which doesn't return any value
*   RecursiveTask : Which Returns a value*/
class MyRecursiveTask extends RecursiveTask<Integer>
{
    int no;
    MyRecursiveTask(int no)
    {
        this.no=no;
    }
    @Override
    protected Integer compute() {
        System.out.println("Thread started "+ Thread.currentThread().getName());
        if(no==0)
        {
            System.out.println("Thread started "+ Thread.currentThread().getName() + " returned 0");
            return 0;
        }
        if(no==1)
        {
            System.out.println("Thread "+ Thread.currentThread().getName() + " returned 1");
            return 1;
        }
        MyRecursiveTask t1 = new MyRecursiveTask(no-1);
        t1.fork();
        MyRecursiveTask t2 = new MyRecursiveTask(no-2);
        t2.fork();
        int res =  t1.join()+t2.join();
        System.out.println("Thread "+ Thread.currentThread().getName() + " returned "+res);
        return res;
    }
}
public class ForkJoinPoolSample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int no = forkJoinPool.invoke(new MyRecursiveTask(6));
        System.out.println(no);
    }
}
