class A{
    int x;
    static {
        System.out.println("Static Block ");
    }
    A(){
        x=10;
        System.out.println("A constructor" + x);
    }
    {
        System.out.println("A instance block1"+x);
    }
    {
        System.out.println("A instance block2");
    }
}
class B extends A{
    static {
        System.out.println("Static Block 2");
    }
    B(){
        System.out.println("B constructor");
    }
    {
        System.out.println("B instance block1");
    }
    {
        System.out.println("B instance block2");
    }
}
public class InstanceControlFlowImpl {
    public static void main(String[] args) {
        new B();
    }
}
