package org.udemy.design_patterns.chain_of_responsibility.broker_chain.assignment;

import java.util.ArrayList;
import java.util.List;

public class Game {

  enum Statistic
  {
    ATTACK, DEFENSE
  }

  public List<Creature> creatures = new ArrayList<>();
}
