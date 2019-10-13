package org.udemy.design_patterns.factory.abstract_factory;

public class Coffee implements HotDrink{

  @Override
  public void consume() {
    System.out.println("The Coffee is delicious");
  }

}
