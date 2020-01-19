package TreeLevelRelatedQueries;

public class MyLinkedList {
    int[] list = new int[100];
    int end=-1;
    void insert(int data)
    {
        list[++end]=data;
    }
}
