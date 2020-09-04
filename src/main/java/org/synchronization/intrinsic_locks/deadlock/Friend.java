package org.synchronization.intrinsic_locks.deadlock;

public class Friend {

  private final String name;

  public Friend(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public synchronized void bow(Friend bower){
    System.out.printf("%s : %s bowed to me !\n", name, bower.getName());
    bower.bowBack(this);
  }

  private synchronized void bowBack(Friend bower){
    System.out.printf("%s : %s bowed back to me !!\n", name, bower.getName() );
  }
}
