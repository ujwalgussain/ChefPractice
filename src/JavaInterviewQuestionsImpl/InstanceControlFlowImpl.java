package JavaInterviewQuestionsImpl;

class A{
    int x;
    static {
        System.out.println("Static Block ");
    }
    A(){
        x=10;
        System.out.println("JavaInterviewQuestionsImpl.A constructor" + x);
    }
    {
        System.out.println("JavaInterviewQuestionsImpl.A instance block1"+x);
    }
    {
        System.out.println("JavaInterviewQuestionsImpl.A instance block2");
    }
}
class B extends A{
    static {
        System.out.println("Static Block 2");
    }
    B(){
        System.out.println("JavaInterviewQuestionsImpl.B constructor");
    }
    {
        System.out.println("JavaInterviewQuestionsImpl.B instance block1");
    }
    {
        System.out.println("JavaInterviewQuestionsImpl.B instance block2");
    }
}
public class InstanceControlFlowImpl {
    public static void main(String[] args) {
        new B();
    }
}
