package org.udemy.design_patterns.chain_of_responsibility.broker_chain;

public class Creature {

  private Game game;
  public String name;

  public  int baseAttack , baseDefense;

  public Creature(Game game, String name, int baseAttack, int baseDefense) {
    this.game = game;
    this.name = name;
    this.baseAttack = baseAttack;
    this.baseDefense = baseDefense;
  }

  public int getAttack(){
    Query query = new Query(name, Query.Argument.ATTACK, baseAttack);
    game.queries.fire(query);

    return query.result;
  }

  public int getDefense(){
    Query query = new Query(name, Query.Argument.DEFENSE, baseDefense);
    game.queries.fire(query);

    return query.result;
  }

  @Override
  public String toString() // avoid printing Game
  {
    return "Creature{" +
        "name='" + name + '\'' +
        ", attack=" + getAttack() + // !!!
        ", defense=" + getDefense() +
        '}';
  }
}
