package org.udemy.design_patterns.chain_of_responsibility.broker_chain;

public class CreatureModifier {

  protected Game game;
  protected Creature creature;

  public CreatureModifier(Game game, Creature creature) {
    this.game = game;
    this.creature = creature;
  }

}

class DoubleAttachModfier extends CreatureModifier implements AutoCloseable {

  private final int token;

  public DoubleAttachModfier(Game game, Creature creature) {
    super(game, creature);

    token = game.queries.subscribe(q -> {
      if (q.creatureName.equals(creature.name) && q.argument == Query.Argument.ATTACK) {
        q.result *= 2;
      }
    });
  }

  public void close(){
    game.queries.unsubscribe(token);
  }
}

class IncreasedDefenseModifier extends CreatureModifier{

  private final int token;
  public IncreasedDefenseModifier(Game game, Creature creature) {
    super(game, creature);

    token = game.queries.subscribe(q -> {
      if (q.creatureName.equals(creature.name) && q.argument == Query.Argument.DEFENSE) {
        q.result += 3;
      }
    });

  }
}