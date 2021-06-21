package Java_Basics.Enums;

public class EnumWithInstanceMethods {

    /*Case 1: Enums with instance methods with same name
    Here SMALL, BIG have same lidCode so will call the outer LidCode() method.
    JUMBO has a different lidCode hence must provide its own implementation
    */
    enum CoffeeSize{
        SMALL,
        BIG,
        JUMBO{
            @Override
            String lidCode() {
                return "B";
            }
        };
        String lidCode()
        {
            return "A";
        }
    }
    /*Case 2 : enum with instance methods inside themselves and dont have a common name:
        Note ACTIVE has m1 and INACTIVE has m2
        Both m1 and m2 will be accessible only within the outer {} brackets
    */
    enum Status {
        ACTIVE {
            @Override
            public void test() {
                m1();
            }

            public String m1() {
                return "m1";
            }
        },
        INACTIVE {
            @Override
            public void test() {
                m2();
            }

            //This methods is accessible within {}
            public String m2() {
                return "m2";
            }
        };

        public abstract void test();

        public static void main(String[] args) {
            //Status.ACTIVE.m1(); //cant access
        }
    }
}
