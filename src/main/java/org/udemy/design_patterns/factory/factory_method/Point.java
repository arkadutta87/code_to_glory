package org.udemy.design_patterns.factory.factory_method;

public class Point {

  private double x, y;

//  private Point(double a, double b, CoordinateSystem coordinateSystem) {
//    switch (coordinateSystem) {
//      case CARTESIAN:
//        this.x = a;
//        this.y = b;
//        break;
//      case POLAR:
//        this.x = a * Math.cos(b);
//        this.y = a * Math.sin(b);
//        break;
//    }
//  }

  private Point(double a, double b) {
    this.x = a;
    this.y = b;
  }


  public static class Factory {
    public static Point newCartesiaPoint(double x, double y) {
      return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
      return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }


  }


}
