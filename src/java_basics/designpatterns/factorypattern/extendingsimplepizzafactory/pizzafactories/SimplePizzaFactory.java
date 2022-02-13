package java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzafactories;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzas.CheesePizza;
import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.Pizza;
import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzas.VeggiePizza;

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
