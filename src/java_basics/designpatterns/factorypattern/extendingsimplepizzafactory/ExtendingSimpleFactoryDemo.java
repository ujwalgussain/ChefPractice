package java_basics.designpatterns.factorypattern.extendingsimplepizzafactory;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzafactories.NYPizzaFactory;
import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzafactories.SimplePizzaFactory;

public class ExtendingSimpleFactoryDemo {
    public static void main(String[] args) {
        //SimplePizzaFactory
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("veggie");

        //NYPizzaFactory
        NYPizzaFactory nyPizzaFactory = new NYPizzaFactory();
        pizzaStore = new PizzaStore(nyPizzaFactory);
        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("veggie");

    }
}
