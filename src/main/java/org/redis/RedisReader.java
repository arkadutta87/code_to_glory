package org.redis;

public class RedisReader {

  public static void main(String[] args) {
    RedisClient redisClient = new RedisClient();
    redisClient.readUGCList("dh6e83b4b5ba7542f8a3405e9087d5572a");
//    redisClient.scanAndDeleteKeys();
  }
}
