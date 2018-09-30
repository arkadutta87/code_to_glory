package org.udemy.design_patterns.chain_of_responsibility.broker_chain;

public class Query {

  public String creatureName;
  enum Argument {
    ATTACK, DEFENSE
  }

  public Argument argument;
  public int result;

  public Query(String creatureName, Argument argument, int result) {
    this.creatureName = creatureName;
    this.argument = argument;
    this.result = result;
  }
}
