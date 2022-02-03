package java_basics.designpatterns.decorator;

public class HouseBlend extends Beverage{
    public HouseBlend() {
        this.description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 20;
    }
}
