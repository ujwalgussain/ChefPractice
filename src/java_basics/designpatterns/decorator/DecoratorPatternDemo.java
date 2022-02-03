package java_basics.designpatterns.decorator;

public class DecoratorPatternDemo {
    /*
    1. Create Beverage Class
    2. Create Expresso, HouseBlend....extending Beverage
    3. Create CondimentDecorator extends Beverage
    4. Create Mocha having Beverage and extending CondimentDecorator
     */

    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        System.out.println("Desc :" + beverage.getDescription());
        System.out.println("Cost " + beverage.cost());
        Mocha mocha = new Mocha(beverage);
        System.out.println("Desc :" + mocha.getDescription());
        System.out.println("Cost :" + mocha.cost());
    }
}
