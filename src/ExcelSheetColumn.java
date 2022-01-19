public class ExcelSheetColumn {
    public Integer convertToDecimal(String A){
        if(A.equals(""))
            return -1;
        int ans = 0;
        for(char c:A.toCharArray()){
            ans=ans*26 + (c-'A'+1); //Here we are using +1 for since A=1 B=2.. and so on.
        }
        return ans;
    }
    String convertToString(int A){
        String ans="";
        while(A!=0){
            char c = (char)(((A%26)-1)+'A');
            A=A/26;
            ans=c+ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumn().convertToDecimal("AAA"));
        System.out.println(new ExcelSheetColumn().convertToString(703));
    }
}
