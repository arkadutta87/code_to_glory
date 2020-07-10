package org.leetcode.design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class TwitterV2 {

  private class TweetNodeV2 {

    public int tweetId;
    public long tweetNumber;

    public TweetNodeV2(int tweetId, long tweetNumber) {
      this.tweetId = tweetId;
      this.tweetNumber = tweetNumber;
    }
  }

  private long tweetIndex;
  private Map<Integer, LinkedList<TweetNodeV2>> userTweets;
  private Map<Integer, Set<Integer>> followersToFollowee;

  public TwitterV2() {
    this.tweetIndex = 0L;
    userTweets = new HashMap<>();
    followersToFollowee = new HashMap<>();
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    if (followeeId != followerId) {
      followersToFollowee.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    if (followeeId != followerId) {
      Set<Integer> followees = followersToFollowee.get(followerId);
      if (Objects.nonNull(followees)) {
        followees.remove(followeeId);
      }
    }
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed
   * or by the user herself. Tweets must be ordered from most recent to least recent.
   */
  //O(nlg(n))
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> feed = new ArrayList<>();
    List<TweetNodeV2> cummulativeTweets = new LinkedList<>();

    LinkedList<TweetNodeV2> firstLevelTweets = userTweets.get(userId);
    if(Objects.nonNull(firstLevelTweets)){
      cummulativeTweets.addAll(firstLevelTweets);
    }


    Set<Integer> followees = followersToFollowee.get(userId);
    if (Objects.nonNull(followees)) {
      for (Integer followee : followees) {
        LinkedList<TweetNodeV2> followeeTweets = userTweets.get(followee);
        if (Objects.nonNull(followeeTweets)) {
          cummulativeTweets.addAll(followeeTweets);
        }
      }
    }

    //now create a max Heap from the cummulative Tweets
    if (!cummulativeTweets.isEmpty()) {
      PriorityQueue<TweetNodeV2> maxHeap = new PriorityQueue<>(cummulativeTweets.size(), new Comparator<TweetNodeV2>() {
        @Override
        public int compare(TweetNodeV2 o1, TweetNodeV2 o2) {
          return (int) (o2.tweetNumber - o1.tweetNumber);
        }
      });

      for (TweetNodeV2 tweet : cummulativeTweets) {
        maxHeap.offer(tweet);
      }

      //find the 10 latest tweets
      int size = maxHeap.size();
      int maxTweets = 10;
      for (int i = 0; i < size && i < maxTweets; i++) {
        feed.add(maxHeap.remove().tweetId);
      }
    }

    return feed;
  }

  /**
   * Compose a new tweet.
   */
  public void postTweet(int userId, int tweetId) {
    userTweets.computeIfAbsent(userId, k -> new LinkedList<>()).offerFirst(new TweetNodeV2(tweetId, ++tweetIndex));
  }
}
