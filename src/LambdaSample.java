public class LambdaSample {
    static int a=0;
    public static void main(String[] args) {
        int a;
        a=2;
        new Thread(()->
        {
            for(int i=0;i<10;i++)
            {
                System.out.println(a);;
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
