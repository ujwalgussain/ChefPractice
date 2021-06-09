package Dynamic_Programming;

public class ActivitySelectionDP {
    public static int selectActivity(Activities a, int prevActIdx, String res)
    {
        //System.out.println("Call prevIdx = "+prevActIdx+" res = " + res);
        if(prevActIdx==a.start.length)
        {
            System.out.println("Res =" +res);
            return 0;
        }
        int[] start = a.getStart();
        int[] end = a.getEnd();

        int i=0;
        //int q= Integer.MIN_VALUE;
        int q=-1;
        while(i<start.length) {
            if (!res.contains(i+"")) {
               // System.out.println("For i = "+i);
                if(prevActIdx==-1||end[prevActIdx]<=start[i]) {



                    //res += " " + (i + "(" + start[i] + "," + end[i] + ") ");
                    res +=i+" ";
                    q = 1 + selectActivity(a, i, res);
                }
            }
            i++;
        }
        return q;
    }
    public static void main(String args[])
    {
        Activities a = new Activities();
        a.setStart(new int[]{1, 3, 0, 5, 8, 5});
        a.setEnd(new int[]{2, 4, 6, 7, 9, 9});
        System.out.println("Res => " +selectActivity(a,-1,""));

    }
}

class Activities{
    int[] start;
    int[] end;
    boolean[] selected;

    public boolean[] getSelected() {
        return selected;
    }

    public void setSelected(boolean[] selected) {
        this.selected = selected;
    }

    public int[] getStart() {
        return start;
    }

    public void setStart(int[] start) {
        this.start = start;
    }

    public int[] getEnd() {
        return end;
    }

    public void setEnd(int[] end) {
        this.end = end;
    }


}
