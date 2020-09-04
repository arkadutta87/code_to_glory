package org.concurrency_cookbook.fork_join.recipe1;

import java.util.List;
import java.util.concurrent.RecursiveAction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task extends RecursiveAction {

  private List<Product> products;
  private int first;
  private int last;
  private double increment;


  @Override
  protected void compute() {

    if (last - first < 10) {
      updatePrices();
    }
    else {
      int middle = (last + first) / 2;
      System.out.printf("Task : Pending Task : %s\n", getQueuedTaskCount());
      Task t1 = new Task(products, first, middle + 1, increment);
      Task t2 = new Task(products, middle + 1, last, increment);
      invokeAll(t1, t2);
    }
  }

  private void updatePrices() {
    for (int i = first; i < last; i++) {
      Product product = products.get(i);
      product.setPrice(product.getPrice() * (1 + increment));
    }
  }
}
