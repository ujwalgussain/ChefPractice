package MultithreadingSample;

public class ReentrancyUsingSynchronized {
    public static void main(String[] args) {
        String s="123";
        Runnable r = () ->{
            synchronized (s)
            {
                System.out.println("1st Lock Acquired");
                synchronized (s) {
                    System.out.println("2nd Lock Acquired");
                    synchronized (s)
                    {
                        System.out.println("3rd Lock Acquired");
                    }
                    System.out.println("3rd Lock Released");
                }
                System.out.println("2nd Lock Released");
            }
            System.out.println("1st Lock Released");
        };
        new Thread(r).start();
    }
}
