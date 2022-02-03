package java_basics;

import java.math.BigDecimal;

public class FloatIssuesInJavaImpl {
    //Dont use float and double if exact answer is required like monetary calculations
    //The right way to solve this problem is to use BigDecimal, int, or long for monetary calculations.
    public static void getItemsBought_float() {
        /*
            1.000000 - 0.100000 = 0.9  - correct
            0.900000 - 0.200000 = 0.7  - correct
            0.700000 - 0.300000 = 0.3999999999999999 - incorrect it should be 0.40
            3 items bought.
            Change: $0.3999999999999999
        */
        System.out.println("Incorrect Solution");
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            System.out.printf("%f - %f = ", funds, price);
            funds -= price;
            System.out.println(funds);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }

    public static void getItemsBought_BigDecimal() {
        System.out.println("Correct Result");
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            System.out.printf("%s - %s = ",funds,price);
            funds = funds.subtract(price);
            System.out.println(funds);
            itemsBought++;
        }
        System.out.println(itemsBought +
                " items bought.");
        System.out.println("Money left over: $" + funds);
    }

    public static void main(String[] args) {
        getItemsBought_float();
        getItemsBought_BigDecimal();
    }
}
