package java_basics.Enums;

interface Operation{
    double apply(int x, int y);
}
enum BasicOperation implements Operation
{
    PLUS{
        @Override
        public double apply(int x, int y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double apply(int x, int y) {
            return x-y;
        }
    },
    DIVIDE{
        @Override
        public double apply(int x, int y) {
            return x/y;
        }
    },
    MULTIPLY{
        @Override
        public double apply(int x, int y) {
            return x*y;
        }
    }
}
enum ExtendedOperation implements Operation{
    MOD{
        @Override
        public double apply(int x, int y) {
            return x%y;
        }
    },
    EXP{
        @Override
        public double apply(int x, int y) {
            return Math.pow(x,y);
        }
    }
}
public class EnumInhertianceImpl {
    public static void main(String[] args) {
        //Adv: Now we can have all operations both basic and extended under Operation
        Operation minus = BasicOperation.MINUS;
        System.out.println(minus.apply(2,1));
        Operation mod = ExtendedOperation.MOD;
        System.out.println(mod.apply(2,1));

        //Adv: We can call all methods at over
        test(ExtendedOperation.class,2,2);
    }

    //<T extends Enum<T> & Operation> - This ensures that T is an Enum and implements Operation
    //Learn Generics
    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType,
            int x,
            int y
    ) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%d %s %d = %f%n",
                    x, op, y, op.apply(x, y));
    }

}
