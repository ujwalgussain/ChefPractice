package Java_Basics.Streams;

import java.util.stream.Stream;

public class GenerateEvenNos {
    //Here I could only find that we can generate stream only with previous record.
    //Question : could we use it for fibonacci series generation????
    public static Stream evenNos()
    {
        return Stream.iterate(2,x->x+2); //Here x represents the last/previous entry
    }

    public static void main(String[] args) {
        evenNos().limit(10).forEach(System.out::println);
    }
}
