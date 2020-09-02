
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Animal
{
    public void run()
    {
        System.out.println("Animals run");
    }
}
class Dog extends Animal
{
    @Override
    public void run() {
        System.out.println("Dog run");
    }
}
class Cat extends Animal
{
    @Override
    public void run() {
        System.out.println("Cats run");
    }
}
class Codechef
{
    static void myMethod(Animal a)
    {
        if(a instanceof Dog)
            ((Dog)a).run();
        if(a instanceof Cat)
            ((Cat)a).run();
    }
    static void test(int i)
    {
        test(i+1);
        test(i-1);
    }
    public static void main(String[] args) {
        try {
    test(10);
        } catch (Throwable e) {
            // TODO: handle exception

            System.out.println("Error occured" + e.getClass());
        }
    }
    /*
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = s.nextInt();
        }
        ArrayList<ArrayList<Integer>> arr2= new ArrayList<>();
        arr2.add(new ArrayList<>());
        arr2.get(0).add(arr[0]);
        int  listindex = 0;
        int index = 1;
        while(index<=n-1)
        {
            if(arr[index]<(arr[index-1]))
            {
                arr2.get(listindex).add(arr[index]);
            }
            else{
                listindex+=1;
                arr2.add(new ArrayList<>());
                if(listindex==k-1)
                {
                    while(index<=n-1)
                    {
                        arr2.get(listindex).add(arr[index]);
                        index++;
                    }
                    break;
                }
                arr2.get(listindex).add(arr[index]);
            }
            index++;
        }
        Collections.sort(arr2,new Comparator<ArrayList<Integer>>(){

            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                return a.get(0)-b.get(0);
            }

        });
        for(int i=0;i<arr2.size();i++)
        {
            for(int j=0;j<arr2.get(i).size();j++)
                System.out.print(arr2.get(i).get(j)+" ");
        }


    }*/
}