package ChefProblems;

import java.util.*;

public class CHEFRAIL_Impl {
    class Triangle {
        HashSet < String > edge = new HashSet();
        Triangle(String...s) {
            edge.add(s[0]);
            edge.add(s[1]);
            edge.add(s[2]);
        }

        @Override
        public String toString() {
            return edge.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Triangle)
                return false;
            if (obj == this)
                return true;
            else {
                Triangle t = (Triangle) obj;
                Iterator < String > s = t.edge.iterator();
                while (s.hasNext()) {
                    if (!this.edge.contains(s.next()))
                        return false;
                }
                return true;
            }
        }
    }
    void approch1()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;
        while (--T >= 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            long[] x = new long[N];
            boolean[] x_f = new boolean[N];
            long[] y = new long[M];
            boolean[] y_f = new boolean[M];
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextLong();
            }
            for (int i = 0; i < M; i++) {
                y[i] = sc.nextLong();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            int count = 0;

            /*System.out.println(Arrays.toString(x));
            System.out.println(Arrays.toString(y));
            */
            for (int i = 0; i < N; i++) {
                long x1 = x[i];
                if (x_f[i])
                    continue;
                for (int j = 0; j < M; j++) {
                    //System.out.println("i="+i+" j="+j);
                    long y1 = y[j];

                    if (y_f[j])
                        continue;
                    int c = 0;
                    if ((x1 * x1) % y1 == 0) {
                        long y2 = -((x1 * x1) / y1);
                        //System.out.printf("x1=%d,y1=%d ",x1,y1);
                        int ans = Arrays.binarySearch(y, y2);
                        if (y1 != y2 && ans > 0) {
                            /*System.out.printf("x1=%d,y1=%d ",x1,y1);
                            System.out.printf("Found y2=%d\n",y2);
                            */
                            count++;
                            y_f[ans] = true;
                            c++;
                        }
                    }
                    if ((y1 * y1) % x1 == 0) {
                        long x2 = -((y1 * y1) / x1);
                        int ans = Arrays.binarySearch(x, x2);
                        if (x1 != x2 && ans > 0) {
                            /*System.out.printf("x1=%d,y1=%d ",x1,y1);
                            System.out.printf("Found x2=%d\n",x2);
                            */
                            count++;
                            x_f[ans] = true;
                            c++;
                        }
                    }
                    if (c == 2) {
                        count += 2;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static public void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;
        while (--T >= 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            long[] x = new long[N];
            //boolean[] x_f = new boolean[N];
            long[] y = new long[M];
            //boolean[] y_f = new boolean[M];
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextLong();
            }
            for (int i = 0; i < M; i++) {
                y[i] = sc.nextLong();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            int count = 0;
            HashSet<HashSet<String>> set = new HashSet<>();
            /*System.out.println(Arrays.toString(x));
            System.out.println(Arrays.toString(y));
            */
            for (int i = 0; i < N; i++) {
                long x1 = x[i];
                if (x1 == 0)
                    continue;
                for (int j = 0; j < M; j++) {
                    //System.out.println("i="+i+" j="+j);
                    long y1 = y[j];
                    if (y1 == 0)
                        continue;
                    int c = 0;
                    if ((x1 * x1) % y1 == 0) {
                        long y2 = -((x1 * x1) / y1);
                        //System.out.printf("x1=%d,y1=%d ",x1,y1);
                        int ans = Arrays.binarySearch(y, y2);
                        if (y1 != y2 && ans > 0) {
                            /*System.out.printf("x1=%d,y1=%d ",x1,y1);
                            System.out.printf("Found y2=%d\n",y2);
                            */
                            count++;
                            HashSet<String> hs = new HashSet();
                            hs.add(String.format("%d,0",x1));
                            hs.add(String.format("0,%d",y1));
                            hs.add(String.format("0,%d",y2));
                            set.add(hs);
                            c++;
                        }
                    }
                    if ((y1 * y1) % x1 == 0) {
                        long x2 = -((y1 * y1) / x1);
                        int ans = Arrays.binarySearch(x, x2);
                        if (x1 != x2 && ans > 0) {
                            /*System.out.printf("x1=%d,y1=%d ",x1,y1);
                            System.out.printf("Found x2=%d\n",x2);
                            */
                            count++;
                            HashSet<String> hs=new HashSet<>();
                            hs.add(String.format("%d,0",x1));
                            hs.add(String.format("0,%d",y1));
                            hs.add(String.format("%d,0",x2));
                            set.add(hs);
                            c++;
                        }
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}