package org.synchronization.fork_join.util;

import java.util.ArrayList;
import java.util.List;

import org.synchronization.fork_join.model.Product;

public class ProductListGenerator {

  public List<Product> generate(int size){
    List<Product> generatedList  = new ArrayList<>();

    for(int i = 0 ; i < size ; i++){
      Product product = new Product();
      product.setName("Product "+i);
      product.setPrice(10);
      generatedList.add(product);
    }

    return generatedList;
  }
}
