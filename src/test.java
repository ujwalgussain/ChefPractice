import java.util.Scanner;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class test
{
   /* static TreeMap<Integer,Integer> map = new TreeMap<>();
    public static int iterative(int arr[], int k)
    {
        map = new TreeMap<>();
        int n = arr.length;
        int pow_n = 1<<n;
        for (int i=0;i<pow_n;i++)
        {
            int sum= 0,len=0;
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                    sum+=arr[j];len++;
                }
                if(len>k)
                    break;
            }
            if(len == k){
                map.put(sum, map.containsKey(sum)?map.get(sum)+1:1);
            }
        }
        return map.firstEntry().getValue();
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = 0;
        if(sc.hasNext())
            test = sc.nextInt();
        int i =-1;
        while(++i<test)
        {
            int n = 0;
            if(sc.hasNext())
                n = sc.nextInt();
            int k = 0;
            if(sc.hasNext())
                k=sc.nextInt();
            int arr[] = new int[n];
                    int j = -1;
                while(++j<n)
                {

                    arr[j]=sc.nextInt();
            }
            System.out.println(iterative(arr,k));
        }
    }*/
   static class Reader
   {
       final private int BUFFER_SIZE = 1 << 16;
       private DataInputStream din;
       private byte[] buffer;
       private int bufferPointer, bytesRead;

       public Reader()
       {
           din = new DataInputStream(System.in);
           buffer = new byte[BUFFER_SIZE];
           bufferPointer = bytesRead = 0;
       }

       public Reader(String file_name) throws IOException
       {
           din = new DataInputStream(new FileInputStream(file_name));
           buffer = new byte[BUFFER_SIZE];
           bufferPointer = bytesRead = 0;
       }

       public String readLine() throws IOException
       {
           byte[] buf = new byte[64]; // line length
           int cnt = 0, c;
           while ((c = read()) != -1)
           {
               if (c == '\n')
                   break;
               buf[cnt++] = (byte) c;
           }
           return new String(buf, 0, cnt);
       }

       public int nextInt() throws IOException
       {
           int ret = 0;
           byte c = read();
           while (c <= ' ')
               c = read();
           boolean neg = (c == '-');
           if (neg)
               c = read();
           do
           {
               ret = ret * 10 + c - '0';
           } while ((c = read()) >= '0' && c <= '9');

           if (neg)
               return -ret;
           return ret;
       }

       public long nextLong() throws IOException
       {
           long ret = 0;
           byte c = read();
           while (c <= ' ')
               c = read();
           boolean neg = (c == '-');
           if (neg)
               c = read();
           do {
               ret = ret * 10 + c - '0';
           }
           while ((c = read()) >= '0' && c <= '9');
           if (neg)
               return -ret;
           return ret;
       }

       public double nextDouble() throws IOException
       {
           double ret = 0, div = 1;
           byte c = read();
           while (c <= ' ')
               c = read();
           boolean neg = (c == '-');
           if (neg)
               c = read();

           do {
               ret = ret * 10 + c - '0';
           }
           while ((c = read()) >= '0' && c <= '9');

           if (c == '.')
           {
               while ((c = read()) >= '0' && c <= '9')
               {
                   ret += (c - '0') / (div *= 10);
               }
           }

           if (neg)
               return -ret;
           return ret;
       }

       private void fillBuffer() throws IOException
       {
           bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
           if (bytesRead == -1)
               buffer[0] = -1;
       }

       private byte read() throws IOException
       {
           if (bufferPointer == bytesRead)
               fillBuffer();
           return buffer[bufferPointer++];
       }

       public void close() throws IOException
       {
           if (din == null)
               return;
           din.close();
       }
   }


    public static void main (String[] args) throws IOException {
        //code
        Reader s=new Reader();
        int t=s.nextInt();
        while(t>0) {
            t--;
            int n=s.nextInt();
            int m = s.nextInt();
            // int[] arr = new int[n + 1];
            ArrayList<Integer>[] ma2 = new ArrayList[n + 1];
            for(int i = 0; i < n + 1; i++) ma2[i] = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                int u = s.nextInt();
                //	arr[u]++;
                int v = s.nextInt();
                //arr[v]++;
                ma2[u].add(v);
                ma2[v].add(u);
            }
            if(m % 2 == 0) {
                System.out.println(1);
                for(int i = 1; i <= n; i++) {
                    System.out.print("1 ");
                }
                System.out.println();
            }
            else {
                boolean b = true;
                int odd = 0;
                for(int i = 1; i <= n ; i++) {
                    if(ma2[i].size() % 2 != 0) {
                        odd = i;
                        b = false;
                        //break;
                    }
                }
                if(b == true) {
                    int x = -1;
                    System.out.println(3);
                    boolean z = true;
                    //int count = 2;
                    for(int i = 1; i <= n; i++) {
                        if(x == -1 && ma2[i].size() > 0) {
                            System.out.print(2 + " ");
                            x = ma2[i].get(0);
                            //count++;
                        }
                        else if(i ==x && z) {
                            System.out.print(3 + " ");
                            z = false;
                        }
                        else
                            System.out.print("1 ");
                    }
                }
                else {
                    System.out.println(2);
                    for(int i = 1; i <= n; i++) {
                        if(i == odd)
                            System.out.print("2 ");
                        else
                            System.out.print("1 ");
                    }

                }
                System.out.println();
            }
        }
    }

}

