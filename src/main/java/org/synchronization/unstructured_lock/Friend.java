package org.synchronization.unstructured_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Friend {

  private final String name;
  private final Lock lock = new ReentrantLock();

  public Friend(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public boolean impendingBow(Friend friend){
    Boolean myLock = false;
    Boolean yourLock = false;

    try{
      myLock = lock.tryLock();
      yourLock = friend.lock.tryLock();
    }finally {
      if(!(myLock && yourLock)){
        if(myLock){
          lock.unlock();
        }

        if(yourLock){
          friend.lock.unlock();
        }
      }
    }

    return myLock && yourLock;
  }

  public void bow(Friend bower){
    if(impendingBow(bower)){
      try{
        System.out.printf("%s : %s has bowed to me !\n", this.name, bower.getName());
        bower.bowBack(this);
      }finally {
        lock.unlock();
        bower.lock.unlock();
      }
    }else{
      System.out.printf("%s : %s started to bow to me , but saw that I was already bowing to him.\n", this.name, bower.getName());
    }
  }

  private void bowBack(Friend bower){
    System.out.printf("%s : %s has bowed back to me! \n", this.name, bower.getName());
  }
}
