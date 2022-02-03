package java_basics.designpatterns.decorator;

public class Expresso extends Beverage {
    public Expresso() {
        this.description = "Expresso";
    }

    @Override
    public double cost() {
        return 10;
    }
}
