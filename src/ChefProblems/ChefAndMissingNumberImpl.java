package ChefProblems;

import java.util.HashMap;
import java.util.Scanner;
//import org.json.*;
public class ChefAndMissingNumberImpl {
    static long limit =(long)Math.pow(10,12);
    static HashMap<String,Integer> power_map= new HashMap<>();
    class Number{
        String dataStr,baseStr;
        int[] data;
        int base;
        int baseEquivalent = 0;
        boolean isBaseSpecified = false;
        Number(String s)
        {
            String arr[] = s.split("\\s");
           getDigitsForNumber(arr[1]);
           if(!arr[0].equals("-1"))
           {
               base = Integer.parseInt(arr[0]);
               isBaseSpecified = true;
           }
           baseEquivalent = getDecimalEquivalentForBase(data,base);
        }
        void incrementBase()
        {
            baseEquivalent = getDecimalEquivalentForBase(data,++base);
        }
        void getDigitsForNumber(String s)
        {
            data= new int[s.length()];
            int i = -1;
           // int maxDigit = Integer.MIN_VALUE;
            while(++i<s.length())
            {
                int digit = getIntegerEquivalentForDigit(s.charAt(i));
                data[i] = digit;
                if(digit > base) {
                    //System.out.println("Digit" + digit);
                    base = digit;
                }
            }
            //System.out.println("Base " + base);
            base +=1;
            //System.out.println("Base " + base);
        }
    }
    static int getIntegerEquivalentForDigit(char c)
    {

        if(c>='A' && c<='Z')
            return (c-'A')+10;
        else
            return c-'0';
    }
    static int getMinBaseForNumber(String s)
    {
        int i = -1;
        int maxDigit = Integer.MIN_VALUE;
        while(++i<s.length())
        {
            int digit = getIntegerEquivalentForDigit(s.charAt(i));
            if(digit > maxDigit)
                maxDigit = digit;
        }
        return maxDigit+1;
    }
    static int getDecimalEquivalentForBase(int[] arr, int base)
    {
        int mul = base;
        int i =arr.length-1;
        int result  = arr[i]*1;
        while(--i>=0)
        {
          // System.out.printf("result %s  mul %s\n",result,mul);
            result+=(arr[i]*mul);
            mul*=base;
        }
        return result;
    }
    static boolean calculate(int pos, Number[] numbers)
    {
        if(pos>=numbers.length)
            return true;
        else
        {
            display(numbers);
            if(numbers[pos].base>36)
                return false;
            if(pos==0)
            {
                //return cal(pos+1)
                return calculate(pos+1,numbers);
            }
            else
            {
                //return
                if(numbers[pos-1].baseEquivalent == numbers[pos].baseEquivalent)
                {
                    return calculate(pos+1,numbers);
                }
                else
                {
                    if(numbers[pos-1].baseEquivalent < numbers[pos].baseEquivalent)
                    {
                        //increment base of pos-1
                        numbers[pos-1].incrementBase();
                        //cal (pos-1)
                        return calculate(pos-1, numbers);
                    }
                    else
                    {
                        //increment base of pos
                        if(numbers[pos].isBaseSpecified)
                            return false;
                        numbers[pos].incrementBase();
                        //cal (pos)
                        return calculate(pos,numbers);
                    }
                }
            }
        }
    }
    static int calculateIterative(Number[] numbers)
    {
        int pos = 0;
        while(pos<numbers.length)
        {
            display(numbers);
            if(numbers[pos].base>36)
            {
                System.out.println("Stop");
                return -1;
            }
            if(pos == 0)
            {
                System.out.println("Pos=0 Increment Pos=1");
                pos++;
            }
            else{
                if(numbers[pos-1].baseEquivalent == numbers[pos].baseEquivalent)
                {
                    System.out.printf("Pos=%s is Equal to Pos=%s, hence Increment to Pos=%s\n",pos-1,pos,pos+1);
                    pos+=1;
                }
                else
                {
                    if(numbers[pos-1].baseEquivalent < numbers[pos].baseEquivalent)
                    {
                        System.out.printf("Pos=%s is less than Pos=%s",pos-1,pos,pos+1);
                        if(!numbers[--pos].isBaseSpecified){
                            System.out.printf("Base not specified hence increment pos = %s\n",pos);
                            numbers[pos].incrementBase();
                        }
                        else{
                            System.out.printf("Base specified hence stop\n");
                            return -1;
                        }

                    }
                    else
                    {
                        System.out.printf("Pos=%s is less than Pos=%s",pos-1,pos,pos+1);
                        if(!numbers[pos].isBaseSpecified)
                        {
                            System.out.printf("Base not specified hence increment pos = %s\n",pos);
                            numbers[pos].incrementBase();
                        }
                        else
                        {
                            System.out.printf("Base specified hence stop");
                            return -1;
                        }

                    }
                }
            }

        }
        return numbers[0].baseEquivalent;
    }

    static public void main(String  args[])
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount=0;
        if(sc.hasNext())
            testCaseCount = sc.nextInt();
        int i =-1;
        while(++i<testCaseCount)
        {
            int N = 0;
            if(sc.hasNext())
                N=sc.nextInt();
            Number numbers[] = new Number[N];
            String s = "";
            for(int j =0;j<N;j++)
            {
                numbers[j] = new ChefAndMissingNumberImpl().new Number(sc.next()+" "+sc.next());
            }
            System.out.println(calculateIterative(numbers));
        }
    }

    static void display(Number[] n)
    {
        String s ="";
        for(int i=0;i<n.length;i++)
        {
            s+=String.format("{%s-%s}  ",n[i].baseEquivalent,n[i].base);
        }
        System.out.println(s);
    }
    static void m1()
    {
        String s ="-1 1111\n-1 104\n-1 44\n";
        String strarr[] = s.split("\\s");
        // System.out.println(getDecimalEquivalentForBase(new int[]{4,4,4},5));
        //System.out.println((int)'0' + " " + (int)'9');
        Number[] n = new Number[]{new ChefAndMissingNumberImpl().new Number("3 1111"),
                new ChefAndMissingNumberImpl().new Number("-1 104"),
                new ChefAndMissingNumberImpl().new Number("9 44")};
        System.out.println(calculate(0,n));
    }
}
