package MultithreadingSample;
class ParentThread extends Thread
{
    static InheritableThreadLocal tl = new InheritableThreadLocal(){
        @Override
        protected Object childValue(Object parentValue) {
            return "cc";
        }
    };
    @Override
    public void run() {
        tl.set("parentValue");
        System.out.println("Parent Thread tl val="+tl.get());
        new ChildThread().start();
    }
}
class ChildThread extends Thread
{
    @Override
    public void run() {
        System.out.println("Child Thread tl val="+ParentThread.tl.get());
    }
}
public class ThreadLocalParentChildSample {
    public static void main(String[] args) {
        new ParentThread().start();
    }
}
