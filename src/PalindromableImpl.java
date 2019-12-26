import java.util.HashSet;

public class PalindromableImpl {
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
        System.out.println(isPalindromable("AMAM")?"is Palindromable":"is not Palindromable");
    }
}
