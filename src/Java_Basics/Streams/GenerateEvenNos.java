package Java_Basics.Streams;

import java.util.stream.Stream;

public class GenerateFibonaciNos {
    public static Stream evenNos()
    {
        return Stream.iterate(2,x->x+2);
    }

    public static void main(String[] args) {
        evenNos().limit(10).forEach(System.out::println);
    }
}
