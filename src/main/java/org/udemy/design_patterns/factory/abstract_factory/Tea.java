package org.udemy.design_patterns.factory.abstract_factory;

public class Tea implements HotDrink{

  @Override
  public void consume() {
    System.out.println("The Tea is delicious");
  }
}
