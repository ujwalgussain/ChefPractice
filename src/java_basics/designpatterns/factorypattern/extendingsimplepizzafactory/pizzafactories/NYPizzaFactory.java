package java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzafactories;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.Pizza;
import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzas.nypizza.NYCheesePizza;
import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzas.nypizza.NYVeggiePizza;

public class NYPizzaFactory extends SimplePizzaFactory{
    public Pizza createPizza(String type){
        switch (type){
            case "cheese":
                return new NYCheesePizza();
            case "veggie":
                return new NYVeggiePizza();
            default:
                throw new RuntimeException("Pizza type invalid");
        }
    }
}
