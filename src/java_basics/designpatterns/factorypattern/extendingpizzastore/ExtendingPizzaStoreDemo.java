package java_basics.designpatterns.factorypattern.extendingpizzastore;


import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.impl.ChicagoPizzaStore;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.impl.NYPizzaStore;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.PizzaStore;

public class ExtendingPizzaStoreDemo {
    /*
                    PizzaStore(Abstract)  <-----abstract creator class
                       /                \
                      /                  \
                     /                    \
                NYPizzaStore            ChicagoPizzaStore   <----------CONCRETE creators

                ABSTRACT CREATOR class: It defines an abstract factory method that the subclasses implement to produce products.
                    Often the creator contains code that depends on an abstract product, which is produced by a subclass.
                    The creator  never really knows which concrete product was produced.
m                CONCRETE creators:
                    Classes that produce products.
                    The createPizza() method is our factory method. It produces products.
                    Since each franchise gets its own subclass of PizzaStore, it’s free to create its own style of pizza by implementing createPizza().

        PRODUCT CLASSES:
              Pizza(Abstract)
              /       /
             /       /
            /       /
   NYCheesePizza   /
             NYVeggiePizza ......

             Factories produce products, and in the PizzaStore, our product is a Pizza.
These are the concrete products - all the pizzas that are produced by our stores.
     */
    public static void main(String[] args) {
        System.out.println("==========NY PIZZA STORE===============");
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
        System.out.println();
        pizzaStore.orderPizza("veggie");

        System.out.println();
        System.out.println("==========Chicago PIZZA STORE===============");
        pizzaStore = new ChicagoPizzaStore();
        pizzaStore.orderPizza("cheese");
        System.out.println();
        pizzaStore.orderPizza("veggie");
    }
}
