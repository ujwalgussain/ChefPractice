package a_practiceproblems.NumberProblems.romannumerals;

import java.util.LinkedHashMap;

public class DecimalToRoman {
    /*
    Logic: If A=36
    1000>36, check with next roman numeral, result =""
    900>36, check with next roman numeral, result =""
    500>36, check with next roman numeral, result =""
    400>36, check with next roman numeral, result =""
    90>36, check with next roman numeral, result =""
    50>36, check with next roman numeral, result =""
    40>36, check with next roman numeral, result =""
    10<36, add corresponding literal 'X' to result , result =X, N = 36-10=26
    10<26, add corresponding literal 'X' to result , result =XX, N = 26-10=16
    10<16, add corresponding literal 'X' to result , result =XXX, N = 16-10=6
    10>6, check with next roman numeral, result =XXX
    9>6, check with next roman numeral, result =XXX
    5<6, add corresponding literal 'V' to result , result =XXXV, N = 6-5=1
    5>1, check with next roman numeral, result =XXXV
    4>1, check with next roman numeral, result =XXXV
    1==1, add corresponding literal 'I' to result , result =XXXVI, N = 1-1=0
    Result = XXXVI
    */
    public String intToRoman(int A) {
        String ans = "";
        LinkedHashMap<Integer, String> literalMap = getMap();
        for (Integer i : literalMap.keySet()) {
            while (A >= i) {
                ans += literalMap.get(i);
                A -= i;
            }
        }
        return ans;
    }

    public LinkedHashMap<Integer, String> getMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new DecimalToRoman().intToRoman(45));
    }
}
