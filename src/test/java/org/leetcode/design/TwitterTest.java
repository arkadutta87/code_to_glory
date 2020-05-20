package org.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TwitterTest {

  @Test
  public void testTwitterPositiveCase(){
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(5));
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(6, 5));
    twitter.unfollow(1, 2);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(5));
  }
}
