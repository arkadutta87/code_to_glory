package org.synchronization.unstructured_lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BowLoop implements Runnable {

  private Friend bower;
  private Friend bowee;

  public BowLoop(Friend bower, Friend bowee){
    this.bower = bower;
    this.bowee = bowee;
  }

  @Override
  public void run() {
    Random random = new Random();
    for(;;){
      try{
        TimeUnit.MILLISECONDS.sleep(random.nextInt(10));
      }catch (InterruptedException e){

      }

      bowee.bow(bower);
    }
  }
}
