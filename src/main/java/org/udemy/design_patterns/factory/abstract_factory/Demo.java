package org.udemy.design_patterns.factory.abstract_factory;

public class Demo {

  public static void main(String[] args) throws Exception{

    HotDrinkMachine machine = new HotDrinkMachine();
    HotDrink drink = machine.makeDrink();

    drink.consume();
  }
}
