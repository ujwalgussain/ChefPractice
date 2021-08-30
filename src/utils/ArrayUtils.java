package utils;

public class ArrayUtils {
    public static void swap(int[] a, int x, int y)
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void swap(char[] a, int x, int y)
    {
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
