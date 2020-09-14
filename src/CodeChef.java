
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
    /* if x is present in arr[] then returns
       the count of occurrences of x,
       otherwise returns -1. */
    static int count(int arr[], int x, int n)
    {
        // index of first occurrence of x in arr[0..n-1]
        int i;

        // index of last occurrence of x in arr[0..n-1]
        int j;

        /* get the index of first occurrence of x */
        i = first(arr, 0, n-1, x, n);

        /* If x doesn't exist in arr[] then return -1 */
        if(i == -1)
            return i;

      /* Else get the index of last occurrence of x.
         Note that we are only looking in the
         subarray after first occurrence */
        j = last(arr, i, n-1, x, n);

        /* return count */
        return j-i+1;
    }

    /* if x is present in arr[] then returns the
       index of FIRST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int first(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) {
                System.out.printf("x = %d Found %d at %d and prev = %d\n",x,arr[mid],mid,arr[mid-1]);
                return mid;
            }
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid -1), x, n);
        }
        return -1;
    }

    /* if x is present in arr[] then returns the
       index of LAST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int last(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
                return mid;
            else if(x < arr[mid])
                return last(arr, low, (mid -1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};

        // Element to be counted in arr[]
        int x =  3;
        int n = arr.length;
        int c = count(arr, x, n);
        System.out.println(x+" occurs "+c+" times");
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