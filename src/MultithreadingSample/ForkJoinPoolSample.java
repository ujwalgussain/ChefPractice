package MultithreadingSample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MyRecursiveTask extends RecursiveTask<Integer>
{
    int no;
    MyRecursiveTask(int no)
    {
        this.no=no;
    }
    @Override
    protected Integer compute() {
        if(no==0)
        {
            return 0;
        }
        if(no==1)
        {
            return 1;
        }
        MyRecursiveTask t1 = new MyRecursiveTask(no-1);
        t1.fork();
        MyRecursiveTask t2 = new MyRecursiveTask(no-2);
        t2.fork();
        return t1.join()+t2.join();
    }
}
public class ForkJoinPoolSample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int no = forkJoinPool.invoke(new MyRecursiveTask(6));
        System.out.println(no);
    }
}
