import java.util.Scanner;
import java.util.TreeMap;

public class TrainOrWalkImpl {
    static int calculate(int i, int timeElapsed , int N, int A, int B, int C, int D, int P, int Q, int Y,int[] cities)
    {
        //System.out.println("Cal"+ i);
        if(i==B)
        {
            return 0;
        }
        else
        {
            if (i>B)
            {
                return (P*Math.abs(cities[i]-cities[i-1])) + calculate(i-1,timeElapsed+P,N, A, B, C, D, P, Q, Y,cities);
            }
            if(i==C && timeElapsed<=Y)
            {
                int train = (Math.abs(cities[D]-cities[C])*Q)+(Y-timeElapsed)+calculate(D,timeElapsed+((D-C)*Q),N, A, B, C, D, P, Q, Y,cities);
                int walk =  P + calculate(i+1,timeElapsed+P,N, A, B, C, D, P, Q, Y,cities);
                return Math.min(train,walk);
            }
            return P+calculate(i+1,timeElapsed+P,N, A, B, C, D, P, Q, Y,cities);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testCase=0;
        if(sc.hasNext())
            testCase = sc.nextInt();
        int i=-1;
        while(++i<testCase)
        {
            int N=sc.nextInt();
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();
            int D=sc.nextInt();
            int P=sc.nextInt();
            int Q=sc.nextInt();
            int Y=sc.nextInt();
            int cities[] = new int[N+1];
            for(int j=1;j<cities.length;j++)
            {
                cities[j] = sc.nextInt();
            }
           // System.out.println(calculate(1,0,N, JavaInterviewQuestionsImpl.A, JavaInterviewQuestionsImpl.B, C, D, P, Q, Y,cities));
            System.out.println(calculate1(N, A, B, C, D, P, Q, Y,cities));
        }


    }
    static int walk(int A, int B,int P ,int cities[])
    {
        return Math.abs((cities[A]-cities[B]))*P;
    }
    static int calculate1(int N, int A, int B, int C, int D, int P, int Q, int Y, int[] cities)
    {
        //walk b/w src and dest is |JavaInterviewQuestionsImpl.A-JavaInterviewQuestionsImpl.B|*P
        //train -> (|JavaInterviewQuestionsImpl.A-C|*P) + (Y-|JavaInterviewQuestionsImpl.A-C|*P)only if Y>timeElapsed + |C-D|*Q + |D-C|*P
        int walk =walk(A,B,P,cities);
        int train = Integer.MAX_VALUE;
        int timeElapsed = walk(A,C,P,cities);
        if(timeElapsed<=Y && timeElapsed<walk)
        {
            train = timeElapsed + (Y-timeElapsed) + (Math.abs(cities[C]-cities[D])*Q) + walk(D,B,P,cities);
            return Math.min(train,walk);
        }
        return walk;
    }
}
