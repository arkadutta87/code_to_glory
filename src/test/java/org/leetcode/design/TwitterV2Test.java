package org.leetcode.design;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TwitterV2Test {

  @Test
  public void testTwitterPositiveCase() {
    TwitterV2 twitter = new TwitterV2();
    twitter.postTweet(1, 5);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(5));
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(6, 5));
    twitter.unfollow(1, 2);
    Assertions.assertEquals(twitter.getNewsFeed(1), Arrays.asList(5));
  }
}
