package org.udemy.design_patterns.chain_of_responsibility.broker_chain;

import java.util.*;
import java.util.function.Consumer;

public class Event<Args> {

  private int index = 0;
  private Map<Integer, Consumer<Args>> handlers = new HashMap<Integer, Consumer<Args>>();

  public int subscribe(Consumer<Args> handler) {
    int i = index;
    handlers.put(index++, handler);

    return i;
  }

  public void unsubscribe(int key) {
    handlers.remove(key);
  }

  public void fire(Args args) {
    for (Consumer<Args> handler : handlers.values()) {
      handler.accept(args);
    }
  }
}


