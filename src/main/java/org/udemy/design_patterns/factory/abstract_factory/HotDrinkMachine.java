package org.udemy.design_patterns.factory.abstract_factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import javafx.util.Pair;


public class HotDrinkMachine {

  private List<Pair<String, HotDrinkFactory>> namedFactories =
      new ArrayList<>();

  public HotDrinkMachine() throws Exception{

    Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);

    for(Class<? extends HotDrinkFactory> type : types){
      namedFactories.add(new Pair<>(
          type.getSimpleName().replace("Factory" , ""),
          type.getDeclaredConstructor().newInstance()
      ));
    }
  }

  public HotDrink  makeDrink() throws Exception{
    System.out.println("Available Drinks : ");

    for(int index = 0 ; index < namedFactories.size() ; ++index){
      Pair<String, HotDrinkFactory> item = namedFactories.get(index);
      System.out.println(index + ": " + item.getKey());
    }

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      String s;
      int i, amount;
      if((s = bufferedReader.readLine()) != null
          && (i = Integer.parseInt(s)) >= 0
          && i < namedFactories.size()){
        System.out.println("Specify the amount : ");
        s = bufferedReader.readLine();

        if(s != null && (amount = Integer.parseInt(s))> 0 ){
          return namedFactories.get(i).getValue().prepare(amount);
        }
      }

      System.out.println("Incorrect Input, try again");
    }
  }
}
