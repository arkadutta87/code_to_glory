package org.synchronization.fork_join.client;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.synchronization.fork_join.model.Product;
import org.synchronization.fork_join.model.Task;
import org.synchronization.fork_join.util.ProductListGenerator;

public class ProductUpdater {

  public static void main(String[] args) {
    ProductListGenerator productListGenerator = new ProductListGenerator();
    List<Product> products = productListGenerator.generate(10000);

    Task task = new Task(products, 0, products.size()-1, 0.20);
    ForkJoinPool pool = new ForkJoinPool();
    pool.execute(task);

    do {
      System.out.printf("ProductUpdater: Thread Count: %d\n", pool.getActiveThreadCount());
      System.out.printf("ProductUpdater: Thread Steal: %d\n", pool.getStealCount());
      System.out.printf("ProductUpdater: Parallelism: %d\n", pool.getParallelism());
      try {
        TimeUnit.MILLISECONDS.sleep(5);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    while (!task.isDone());

    pool.shutdown();

    if (task.isCompletedNormally()) {
      System.out.printf("ProductUpdater: The process has completed normally.\n");
    }

    products.stream().filter(p -> p.getPrice() != 12.0).forEach(p -> {
      System.out.println("Product : Name : "+ p.getName()+ " && Price : " +  p.getPrice());
    });
    System.out.println("ProductUpdater: End of the program.\n");

  }
}
