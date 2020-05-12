package org.redis;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.lettuce.core.RedisURI;
import io.lettuce.core.ScanIterator;
import io.lettuce.core.api.sync.RedisKeyCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

public class RedisClient {

  private RedisClusterClient clusterClient;

  private static final String REDIS_KEY_PATTERN = "ugc.feedv2.";
//  private StatefulRedisClusterConnection<String, String> connection;

  public RedisClient(){
    RedisURI node1 = RedisURI.create("172.20.12.27", 7000);
    RedisURI node2 = RedisURI.create("172.20.12.27", 7001);

    clusterClient = RedisClusterClient.create(Arrays.asList(node1, node2));
//    RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();
  }

  public void scanAndDeleteKeys(){
    StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
    RedisKeyCommands<String, String> syncCommands = connection.sync();

//    ScanIterator<String> scan = ScanIterator.scan(syncCommands, ScanArgs.Builder.limit(50).match("feedv2"));
    ScanIterator<String> scan = ScanIterator.scan(syncCommands);



    int i= 0 ;
    while(scan.hasNext()){
      i++;
      String redisListName = scan.next();
      System.out.println("The key to be deleted : "+redisListName);
      syncCommands.del(redisListName);
    }

    connection.close();

    System.out.println("***********************************************");
    System.out.println("The total number of keys : " + i);
  }

  public void readUGCList(String uid){
    StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
    RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();

    String redisKey = getRedisKey(uid);
    List<String> values = syncCommands.lrange(redisKey, 0, -1);

    if(Objects.nonNull(values) && !values.isEmpty()){
      System.out.println("The Value in the redis key : "+redisKey + " and the size of the list : " + values.size());
      for(String aVal : values ){
        System.out.println(aVal);
      }

    }

    connection.close();

  }

  private String getRedisKey(String uid){
    return REDIS_KEY_PATTERN + uid;
   }

}
