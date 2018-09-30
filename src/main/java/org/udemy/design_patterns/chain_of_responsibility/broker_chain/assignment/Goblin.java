package org.udemy.design_patterns.chain_of_responsibility.broker_chain.assignment;


public class Goblin extends Creature{

  protected Game game;
  protected int baseAttack =1 , baseDefense = 1;

  public Goblin(Game game){
    this.game = game;
  }

  @Override
  public int getAttack(){
    int increaseOfAttack = 0;

    for(Creature creature : game.creatures){
      if(creature instanceof GoblinKing){
        increaseOfAttack += 1;
      }
    }

    return baseAttack + increaseOfAttack;

  }

  @Override
  public int getDefense(){

    int increaseOfBaseDefense = 0;

    return this.baseDefense + game.creatures.size() -1;

  }
}
