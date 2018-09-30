package org.udemy.design_patterns.chain_of_responsibility.broker_chain;

public class BrokerChainDemo {

  public static void main(String[] args) {
    Game game = new Game();

    Creature goblin = new Creature(game, "Strong Goblin", 2, 2);

    System.out.println(goblin);

    IncreasedDefenseModifier idm = new IncreasedDefenseModifier(game, goblin);


    try(DoubleAttachModfier dam = new DoubleAttachModfier(game, goblin)){
      System.out.println(goblin);
    }

    System.out.println(goblin);

  }
}
