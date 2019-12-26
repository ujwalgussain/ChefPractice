import java.util.Arrays;

public class ReverseWordOrderInStringImpl {
    static String reverse_new(String s)
    {
        int fromIndex=0;
        int i = s.indexOf(" ",fromIndex);
        String result="";
        while(i !=-1)
        {
            result = s.substring(fromIndex,i+1) + result;
            fromIndex = i+1;
            i =  s.indexOf(" ",fromIndex);
        }
        return s.substring(fromIndex,s.length())+" "+ result;
    }
    static public void main(String a[])
    {
        System.out.println(reverse_new("I lov emy india"));
    }
}
