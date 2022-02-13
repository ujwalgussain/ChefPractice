package java_basics.designpatterns.factorypattern.extendingsimplepizzafactory;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzafactories.SimplePizzaFactory;

public class PizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }

}
