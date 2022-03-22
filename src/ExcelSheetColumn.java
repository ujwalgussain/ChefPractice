import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class ExcelSheetColumn {
    public int convertToDecimal(String columnTitle) {
        char s[] = columnTitle.toCharArray();
        int ans = 0, p = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            ans = ans + ((s[i] - 'A' + 1) * (int) Math.pow(26, p++));
        }
        return ans;
    }

    String convertToString(int A) {
        String ans = "";
        while (A != 0) {
            char c = (char) ((((A-1) % 26)) + 'A');
            A = (A-1) / 26;
            //System.out.println(A);
            ans = c + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumn().convertToString(27));
    }
}
