import java.util.*;

public class MindNervesX5ArrangementImpl {
    static void X5arrange(int a[])
    {
        int ptr2 = a.length-1;
        int ptr1 = 0;
        while(ptr1<ptr2)
        {
            int current = a[ptr1];
            System.out.printf("ptr1 %d ptr2 %d current = %d\n", ptr1,ptr2,current);
            if(current%5==0)
            {
                //leftshift from ptr1
                leftShiftAndPut(a,ptr1);
                a[a.length-1] = current;ptr2--;
                System.out.println("After Replace " + Arrays.toString(a));
                continue;
            }
            ptr1++;
        }
        System.out.printf("ptr1 %d ptr2 %d \n", ptr1,ptr2);
    }
    static void leftShiftAndPut(int a[], int ptr)
    {
        for(int i=ptr;i<a.length-1;i++)
        {
            a[i]=a[i+1];
        }
    }
  /*  static String reversesentence(String s)
    {
        //Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        String result = "";
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            System.out.println(c);
            if(c == ' ' )
            {
                //result = result + " " + word;
                result =(result.equals(""))?word.append(result).toString():word.append(" ").append(result).toString();
                word = new StringBuilder();
            }
            else {
                word = word.append(c);
            }
        }
        return word+" "+result;
    }*/
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
    static boolean isPalindromable(String s)
    {
        HashSet<String> odd = new HashSet<>();
        HashSet<String> even = new HashSet<>();
        int len = s.length();
        for(int i = 0;i<len;i++)
        {
            //System.out.printf("Odd %s, Even %s\n",odd,even);
            String c=Character.toString(s.charAt(i));
            if(!odd.contains(c) && !even.contains(c))
            {
                odd.add(c);
            }
            else{
                if(odd.contains(c))
                {
                    odd.remove(c);
                    even.add(c);
                }
                else
                {
                    even.remove(c);
                    odd.add(c);
                }
            }

        }
        if(len%2!=0 && odd.size()==1)
            return true;
        else
        if(len%2 ==0 && odd.size()==0)
            return true;
        else
            return false;


    }
    static public void main(String a[])
    {
        int arr[] = new int[]{2,4,8,5,12,15,6,10,7,30,25,43,46,45,21};
        X5arrange(arr);
        System.out.println(Arrays.toString(arr));
       // System.out.println(reversesentence("I love my india"));
        System.out.println(reverse_new("Ilovemyindia"));
        System.out.println(isPalindromable("AMAM"));
    }
}
