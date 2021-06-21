import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;


public class TestClass {
    static  void m1(ArrayList  list) {
        list.add(20.0);
        list.add(20);
        list.add("string");
    }

    public static void main(String[] args) {
        ArrayList listOfString = new ArrayList<String>();
        ArrayList listOfInteger = new ArrayList<Integer>();
        ArrayList listOfDouble = new ArrayList<Double>();

        System.out.println(listOfDouble.equals(listOfInteger));
        System.out.println(listOfString.equals(listOfDouble));


    }
}
