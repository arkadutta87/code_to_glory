package org.leetcode.google.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddressUtility {


  public static void main(String[] args) {
    UniqueEmailAddressUtility utility = new UniqueEmailAddressUtility();
    int uniqueEmails = utility
        .numUniqueEmails(new String[]{"arka.dutta@dailyhunt.in", "arkadutta@dailyhunt.in", "arka.dutta+123@dailyhunt.in"});

    System.out.println("The Number of unique email addresses -> " + uniqueEmails);
  }

  public int numUniqueEmails(String[] emails) {

    Set<String> emailSet = new HashSet<>();

    for (String aEmailId : emails) {
      emailSet.add(covertToBaseForm(aEmailId));
    }

    return emailSet.size();

  }

  private String covertToBaseForm(String emailId) {

    String[] partsOfEmailId = emailId.split("@");

    if (partsOfEmailId.length == 2) {
      String localPart = partsOfEmailId[0];
      int i = localPart.indexOf('+');

      if (i != -1) {
        localPart = localPart.substring(0, i);
      }

      localPart = localPart.replaceAll("\\.", "");
      emailId = localPart + "@" + partsOfEmailId[1];
    }

    return emailId;
  }
}
