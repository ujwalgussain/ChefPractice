package java_basics.designpatterns.factorypattern.simplepizzafactory;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        switch (type){
            case "cheese":
                return new CheesePizza();
            case "veggie":
                return new VeggiePizza();
            default:
                throw new RuntimeException("Pizza type invalid");
        }
    }
}
