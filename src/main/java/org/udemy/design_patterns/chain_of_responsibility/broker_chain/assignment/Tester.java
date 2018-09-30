package org.udemy.design_patterns.chain_of_responsibility.broker_chain.assignment;

/*
Problem statement -- https://www.udemy.com/design-patterns-java/learn/v4/t/quiz/4350314
 */

public class Tester {

  public static void main(String[] args) {
    Game game = new Game();

    Creature goblin = new Goblin(game);
    Creature goblin1 = new Goblin(game);

    game.creatures.add(goblin);
    game.creatures.add(goblin1);
    System.out.println("Attack : "+ goblin.getAttack());
    System.out.println("Defense : "+ goblin.getDefense());
  }
}
