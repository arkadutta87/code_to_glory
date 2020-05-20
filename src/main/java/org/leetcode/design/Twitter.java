package org.leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Twitter {

  public class HeapNode {

    public int data;
    public long weight;

    public HeapNode(int data, long weight) {
      this.data = data;
      this.weight = weight;
    }

  }

  public class MaxHeap {

    private HeapNode[] heap;
    private int currentLocation;
    private int heapSize;

    public int size() {
      return currentLocation + 1;
    }

    public boolean isEmpty() {
      return size() == 0 ? true : false;
    }

    public MaxHeap(int heapSize) {
      this.heapSize = heapSize;
      this.currentLocation = -1;
      this.heap = new HeapNode[heapSize];
    }

    public <T> boolean insertData(HeapNode node) {
      //insert the node to the last location
      if ((currentLocation + 1) >= heapSize) {
        return false;
      }

      heap[++currentLocation] = node;

      //now check with its parent - if its greater than parent
      int parentIndex = -1;
      int childIndex = currentLocation;
      while ((parentIndex = (childIndex - 1) / 2) >= 0) {
        HeapNode parent = heap[parentIndex];
        if (node.weight > parent.weight) {
          //swap the nodes
          heap[childIndex] = parent;
          heap[parentIndex] = node;

          childIndex = parentIndex;
        }
        else {
          break;
        }
      }

      return true;
    }

    public HeapNode peekMax() {
      return currentLocation == -1 ? null : heap[0];
    }

    public HeapNode deleteMax() {
      if (currentLocation < 0) {
        return null;
      }

      HeapNode max = heap[0];
      //swap root with the last element
      heap[0] = heap[currentLocation--];

      //heapify
      int index = 0;
      int lchildIndex = 2 * index + 1;
      int rchildIndex = 2 * index + 2;

      while (lchildIndex <= currentLocation) {
        HeapNode node = heap[index];
        HeapNode lchild = heap[lchildIndex];

        if (node.weight < lchild.weight) {
          //check lesser between lchild and rchild
          int indexToReplace = lchildIndex;
          if (rchildIndex <= currentLocation) {
            if (heap[rchildIndex].weight > heap[lchildIndex].weight) {
              indexToReplace = rchildIndex;
            }
          }

          heap[index] = heap[indexToReplace];
          heap[indexToReplace] = node;

          index = indexToReplace;
        }
        else {
          //check if node is less than rchild
          if (rchildIndex <= currentLocation) {
            HeapNode rchild = heap[rchildIndex];
            if (node.weight < rchild.weight) {
              //replace with rchild
              heap[index] = heap[rchildIndex];
              heap[rchildIndex] = node;
              index = rchildIndex;
            }
            else {
              break;
            }
          }
          else {
            break;
          }
        }

        lchildIndex = 2 * index + 1;
        rchildIndex = 2 * index + 2;
      }

      return max;
    }

  }

  public class TweetNode {

    public int tweetId;
    public long tweetNo;

    public TweetNode(int tweetId, long tweetNo) {
      this.tweetId = tweetId;
      this.tweetNo = tweetNo;
    }
  }

  private long tweetNumber;//1 based index
  private Map<Integer, LinkedList<TweetNode>> userTweets;
  private Map<Integer, Set<Integer>> followersToFollowee;


  /**
   * Initialize your data structure here.
   */
  public Twitter() {
    this.tweetNumber = 0l;
    userTweets = new HashMap<>();
    followersToFollowee = new HashMap<>();
  }

  /**
   * Compose a new tweet.
   */
  public void postTweet(int userId, int tweetId) {
    LinkedList<TweetNode> tweets = userTweets.computeIfAbsent(userId, k -> new LinkedList<>());
    tweets.addFirst(new TweetNode(tweetId, ++tweetNumber));
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed
   * or by the user herself. Tweets must be ordered from most recent to least recent.
   */
  //O(nlg(n))
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> feed = new ArrayList<>();

    List<TweetNode> competingTweets = new ArrayList<>();
    int max = 10;
    LinkedList<TweetNode> tweetNodes = userTweets.get(userId);
    competingTweets.addAll(tweetNodes == null ? new ArrayList<>() : tweetNodes);

    Set<Integer> followees = followersToFollowee.get(userId);
    if(Objects.nonNull(followees)) {
      for (Integer followeeId : followees) {
        LinkedList<TweetNode> tweetInternal = userTweets.get(followeeId);
        competingTweets.addAll(tweetInternal == null ? new ArrayList<>() : tweetInternal);
      }
    }

    //create the MaxHeap
    if (!competingTweets.isEmpty()) {
      MaxHeap maxHeap = new MaxHeap(competingTweets.size());

      for (TweetNode aTweet : competingTweets) {
        maxHeap.insertData(new HeapNode(aTweet.tweetId, aTweet.tweetNo));
      }

      int heapSize = maxHeap.size();

      for (int i = 0; i < heapSize && i < max; i++) {
        feed.add(maxHeap.deleteMax().data);
      }
    }

    return feed;

  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    if(followerId != followeeId) {
      Set<Integer> followData = followersToFollowee.computeIfAbsent(followerId, k -> new HashSet<>());
      followData.add(followeeId);
    }
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    if(followerId != followeeId) {
      Set<Integer> followData = followersToFollowee.computeIfAbsent(followerId, k -> new HashSet<>());
      followData.remove(followeeId);
    }
  }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter(); obj.postTweet(userId,tweetId); List<Integer>
 * param_2 = obj.getNewsFeed(userId); obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
