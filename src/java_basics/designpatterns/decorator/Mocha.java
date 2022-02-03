package java_basics.designpatterns.decorator;

public class Mocha extends CondimentDecorator{
    private Beverage beverage;

    Mocha(Beverage beverage){
        this.beverage = beverage;
        this.description = beverage.getDescription()+" Mocha";
    }
    @Override
    public double cost() {
        return beverage.cost()+50;
    }


}
