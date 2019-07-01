package org.programming_challenges.pretty_polly.model;

/*
Pretty Polly has no shortage of gentlemen suitors who come a’ courting. Indeed, her biggest problem is keeping track of who the best ones
 are.
She is smart enough to realize that a program which ranks the men from most to least desirable would simplify her life.
She is also persuasive enough to have talked you into writing the program.
Polly really likes to dance, and has determined the optimal partner height is 180 centimeters tall.
Her first criteria is finding someone who is as close as possible to this height;
whether they are a little taller or shorter doesn’t matter.
 Among all candidates of the same height, she wants someone as close as possible to 75 kilograms without going over.
 If all equal-height candidates are over this limit, she will take the lightest of the bunch.
 If two or more people are identical by all these characteristics, sort them by last name,
 then by first name if it is necessary to break the tie.
 */
public class Suitor implements Comparable<Suitor> {

  private static final float BASE_HEIGHT = 180;
  private static final float BASE_WEIGHT = 75;

  private String firstName;
  private String lastName;
  private float heightInCms;
  private float weightInKgs;

  public Suitor(String firstName, String lastName, float heightInCms, float weightInKgs) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.heightInCms = heightInCms;
    this.weightInKgs = weightInKgs;
  }

  @Override
  public int compareTo(Suitor otherSuitor) {
    float diffHeightMe = Math.abs(this.heightInCms - BASE_HEIGHT);
    float diffHeightOther = Math.abs(otherSuitor.getHeightInCms() - BASE_HEIGHT);

    //check the height criteria
    if (diffHeightMe < diffHeightOther) {
      return 1;
    }
    else if (diffHeightMe > diffHeightOther) {
      return -1;
    }
    else {
      //check the weight criteria
      float meWeightDiff = BASE_WEIGHT - this.weightInKgs;
      float otherWeightDiff = BASE_WEIGHT - otherSuitor.getWeightInKgs();

      //both diff positive
      if (meWeightDiff >= 0 && otherWeightDiff >= 0) {
        if (meWeightDiff < otherWeightDiff) {
          return 1;
        }
        else if (meWeightDiff > otherWeightDiff) {
          return -1;
        }
        else {
          return nameProperty(otherSuitor);
        }
      }//both diff negative
      else if (meWeightDiff < 0 && otherWeightDiff < 0) {
        if (meWeightDiff < otherWeightDiff) {
          return -1;
        }
        else if (meWeightDiff > otherWeightDiff) {
          return 1;
        }
        else {
          return nameProperty(otherSuitor);
        }
      }//one negative - one positive
      else {
        if (meWeightDiff < otherWeightDiff) {
          return -1;
        }
        else if (meWeightDiff > otherWeightDiff) {
          return 1;
        }
        else {
          return nameProperty(otherSuitor);
        }
      }
    }
  }

  private int nameProperty(Suitor otherSuitor) {
    int lastNameDiff = otherSuitor.getLastName().compareTo(this.lastName);

    if (lastNameDiff == 0) {
      return otherSuitor.getFirstName().compareTo(this.firstName);
    }
    return lastNameDiff;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public float getHeightInCms() {
    return heightInCms;
  }

  public float getWeightInKgs() {
    return weightInKgs;
  }


}
