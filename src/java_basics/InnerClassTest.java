package java_basics;


class Outer {
    private int a;

    public void outerMethod()
    {
        System.out.println("outer method");
    }
    class NonStaticInner {
        int b;
        public void m1()
        {
            System.out.println(a);
            System.out.println(b);
            outerMethod();
        }
    }

    static class StaticInner {
        int c;
        public void m2()
        {
            /*
            System.out.println(a);
            System.out.println(b);
            outerMethod();
            */
        }
    }

    Outer()
    {
        NonStaticInner non_staticInner = this. new NonStaticInner();// association with outer Object
        StaticInner staticInner = new StaticInner();
    }
}

public class InnerClassTest {

    enum Status{
        ACTIVE("Active");

        Status(String active) {
        }
    }
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.NonStaticInner nonStaticInner = new Outer().new NonStaticInner();

        Outer.StaticInner staticInner = new Outer.StaticInner(); // No reference to outer class

        Status active = Status.valueOf("inactive");

        System.out.println();
    }


}
