package org.synchronization.intrinsic_locks.deadlock;

public class DeadLockSimulator {

  public static void main(String[] args) {
    Friend arka = new Friend("Arka");
    Friend tapas = new Friend("Tapas");

    new Thread(new Runnable() {
      @Override
      public void run() {
        arka.bow(tapas);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        tapas.bow(arka);
      }
    }).start();
  }
}
