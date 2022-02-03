package java_basics;

import java.util.Comparator;

public class AutoboxingIssuesImpl {

    //-------------------------------------ISSUE 1----------------------------------------------------------------
    public static void m1() {
        Comparator<Integer> naturalOrder = (i, j) -> i < j
                ? -1
                : i == j ? 0 : 1;
        {
            //Case 1: Primitive Types - behaves correctly
            System.out.println(naturalOrder.compare(42,42));
        }
        {
            //Case 2: Boxed Primitive Types. Behaves Incorrectly
            Integer i = new Integer(42);
            Integer j = new Integer(42);
            System.out.println(naturalOrder.compare(i, j)); //returns 1 incorrect
        }
        {
            //Case 3: Since we are not using new keyword until 128 java will use same object
            Integer i = 42;
            Integer j = 42;
            System.out.println(naturalOrder.compare(i,j)); //returns 0 correct
        }
        {
            //Case 4: Behaves Incorrectly
            Integer i = 42;
            System.out.println(naturalOrder.compare(i,new Integer(42)));

        }

    }

    //---------------------------------ISSUE 2:------------------------------------------------------------
    static Integer i;
    public static void issue2()
    {
        //This will throw NullPointerException since i is null and JVM will try to unbox i for comparison
        if (i == 42)
            System.out.println("Unbelievable");
    }



    public static void main(String[] args) {
        m1();
        issue2();
    }
}
