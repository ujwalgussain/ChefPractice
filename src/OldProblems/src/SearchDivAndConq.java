package OldProblems.src;

public class SearchDivAndConq {
    static int findNo(int key, int[] arr, int start, int end){
        int idx = -1;
        if(start == end)
        {
            if(arr[start] == key)
                return start;
            else
            {
                return -1;
            }
        }
        if(start< end)
        {
            int mid = (start+end)/2;
            idx = findNo(key, arr, start, mid);
            if(idx == -1)
                idx = findNo(key, arr, mid+1, end);
        }
        return idx;
    }
    static public void main(String args[])
    {
        int arr[] = new int[]{10,20,30,41,20};
        System.out.println("idx =" + findNo(20,arr, 0, arr.length-1));
    }
}
