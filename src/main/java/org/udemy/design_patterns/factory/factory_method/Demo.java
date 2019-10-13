package org.udemy.design_patterns.factory.factory_method;

public class Demo {

  public static void main(String[] args) {

    Point point = Point.Factory.newPolarPoint(2, 3);
  }
}
