package a_practiceproblems.NumberProblems.romannumerals;

public class RomanToDecimalImpl {
    // This function returns
    // value of a Roman symbol
    static int value(char r) {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    static int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int currentSymbol = value(str.charAt(i));
            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int nextSymbol = value(str.charAt(i + 1));
                if (currentSymbol >= nextSymbol)
                    res = res + currentSymbol; // Value of current symbol is greater or equal to the next symbol
                else {
                    // Value of current symbol is less than the next symbol ie., IX or IV
                    res = res + nextSymbol - currentSymbol;
                    i++;
                }
            } else {
                res = res + currentSymbol;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Considering inputs given are valid
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral"
                + " is "
                + romanToDecimal(str));
    }
}
