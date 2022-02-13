package java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.*;

public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }
    //To be implemented by concrete classes
    //Ex: NY Store has its cheese pizza with different ingredients
    public abstract Pizza createPizza(String type);
}
