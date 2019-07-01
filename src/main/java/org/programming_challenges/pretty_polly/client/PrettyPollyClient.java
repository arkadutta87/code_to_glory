package org.programming_challenges.pretty_polly.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.programming_challenges.pretty_polly.model.Suitor;

public class PrettyPollyClient {

  public static void main(String[] args) {

    List<Suitor> suitors = new ArrayList<>();
    suitors.add(new Suitor("George","Bush",195, 110 ));
    suitors.add(new Suitor("Harry","Truman",180, 75 ));
    suitors.add(new Suitor("Bill","Clinton",180, 75 ));
    suitors.add(new Suitor("John","Kennedy",180, 65 ));
    suitors.add(new Suitor("Ronald","Reagan",165, 110 ));
    suitors.add(new Suitor("Richard","Nixon",170, 70 ));
    suitors.add(new Suitor("Jimmy","Carter",180, 77 ));

    Collections.sort(suitors);
    Collections.reverse(suitors);

    for(Suitor aSuitor : suitors){
      System.out.println(aSuitor.getLastName() + ", " + aSuitor.getFirstName());
    }

  }
}
