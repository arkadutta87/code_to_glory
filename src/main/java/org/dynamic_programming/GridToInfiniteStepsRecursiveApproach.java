package org.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//This will give a high runtime - But good for practice
public class GridToInfiniteStepsRecursiveApproach {

  public static void main(String[] args) {

    List<Integer> A = Arrays.asList(-7, -13);
    List<Integer> B = Arrays.asList(1, -5);

    GridToInfiniteStepsRecursiveApproach pathFinder = new GridToInfiniteStepsRecursiveApproach();
    System.out.println(pathFinder.coverPoints(A, B));


  }

  public int coverPoints(List<Integer> A, List<Integer> B) {

    List<Point> pointsToBeTraversed = new ArrayList<>();

    for (int i = 0; i < A.size(); i++) {
      pointsToBeTraversed.add(new Point(A.get(i), B.get(i)));
    }

    int count = 1;

    int numberOfSteps = 0;
    Point currentPosition = pointsToBeTraversed.get(0);
    pointsToBeTraversed.remove(0);

    Queue<Point> traversingSteps = new LinkedList<>();
    traversingSteps.add(currentPosition);

    Set<Point> visitedNodes = new HashSet<>();
    while (pointsToBeTraversed.size() != 0) {

      Point nextPosition = pointsToBeTraversed.get(0);
      int tempCount = 0;
      boolean flag = false;
      for (int i = 0; i < count; i++) {
        Point aPoint = traversingSteps.poll();

        if (aPoint.equals(nextPosition)) {
          //initialize to the starting state
          pointsToBeTraversed.remove(0);
          traversingSteps.clear();
          visitedNodes.clear();
          tempCount = 1;
          traversingSteps.add(nextPosition);
          flag = false;

          break;
        }
        else {
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, 1, 0);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, -1, 0);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, 0, 1);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, 0, -1);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, -1, -1);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, 1, 1);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, -1, 1);
          tempCount = moveOnePointFromPresent(aPoint, visitedNodes, traversingSteps, tempCount, 1, -1);

          if (tempCount > 0) {
            flag = true;
          }

        }

      }
      count = tempCount;
      if (flag)
        numberOfSteps++;

    }

    return numberOfSteps;
  }

  private int moveOnePointFromPresent(Point currentNode, Set<Point> visitedNodes,
                                      Queue<Point> traversingSteps, int currentCount,
                                      int xIncrement, int yIncrement) {
    Point temp = new Point(currentNode.getX() + xIncrement, currentNode.getY() + yIncrement);

    if (!visitedNodes.contains(temp)) {
      visitedNodes.add(temp);
      traversingSteps.add(temp);
      return ++currentCount;
    }

    return currentCount;

  }

  private class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Point))
        return false;

      Point point = (Point) o;

      if (x != point.x)
        return false;
      return y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }
}
