package ChefProblems;

import java.util.*;

public class ChefAndMissingNumberBFImpl {
    static long l = (long)Math.pow(10,12);
    static int getNextInt(Scanner sc)
    {
        return (sc.hasNext())?sc.nextInt():0;
    }
    static int[] convertToDigits(String s)
    {
        int[] result = new int[s.length()];
        int i = -1;
        while(++i<s.length())
        {
            int c = s.charAt(i);
            result[i] =(c>='A' && c<='Z')?c-'A'+10:c-'0';
        }
        return result;
    }
    static int getMinBaseForNumber(int[] arr)
    {
        int i = -1;
        int maxDigit = Integer.MIN_VALUE;
        while(++i<arr.length )
        {
            int digit = arr[i];
            if(digit > maxDigit)
                maxDigit = digit;
        }
        return maxDigit+1;
    }
    static void missingNo()
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = getNextInt(sc);
        int testCaseCounter = -1;
        while(++testCaseCounter<testCaseCount)
        {
            int N = getNextInt(sc);
            String[] s = new String[N];
            int[][] input = new int[N][];
            int[] base = new int[N];
            List<HashSet<Long>> list = new ArrayList<>();
            for(int i=0;i<N;i++)
            {
                base[i] = getNextInt(sc);
                s[i] = sc.hasNext()?sc.next():"";
                input[i] = convertToDigits(s[i]);
            }
            for(int i=0;i<N;i++)
            {
                HashSet<Long> set = new HashSet<>();
                if(base[i]==-1)
                {
                    int startBase =getMinBaseForNumber(input[i]);
                    for(int currbase=startBase; currbase<=36;currbase++)
                    {
                        Long l = getBaseEquivalent(currbase,input[i]);
                        set.add(l);
                        if(l==-1)
                            break;
                    }
                }
                else
                {
                    set.add(getBaseEquivalent(base[i],input[i]));
                }
                list.add(set);
                //  System.out.printf("%s-%s\n",s[i],list.get(i));
            }
            TreeSet<Long> set= new TreeSet<>(list.get(0));
            boolean ansfound = true;
            Long ans=new Long(-1);
            Iterator<Long> itr = set.iterator();
            while(itr.hasNext())
            {
                Long data = itr.next();
                if(data==-1L)
                    continue;
                //System.out.printf("%d ",data);
                ansfound =true;
                for(int j=1;j<N;j++)
                {
                    HashSet hs = list.get(j);
                    ansfound = ansfound&&hs.contains(data);
                }
                //System.out.printf("Ans %s ",ansfound);
                if(ansfound)
                {
                    ans=data;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
    static long getBaseEquivalent(int base, int[] input)
    {
        long a = 0;
        for(int j=0;j<input.length;j++)
        {
            a = (a*base)+input[j];
            if(a>l)
                return -1L;
        }
        return a;
    }
    public static void main(String []args){
        //System.out.println(l);
        missingNo();
    }
}
