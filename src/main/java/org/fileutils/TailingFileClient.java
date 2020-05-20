package org.fileutils;

import java.util.List;

public class TailingFileClient {

//  private static final String FILE_NAME = "/Users/arkadutta/Documents/elastic_stack/logstash/logstash-7.6.2/config/jvm.options";
  private static final String FILE_NAME = "/Users/arkadutta/Documents/elastic_stack/reco_old/access.log";
//  private static final String FILE_NAME = "/Users/arkadutta/Documents/elastic_stack/reco_new/re-web.log";

  public static void main(String[] args) {
    FileTailer tailer = new ApacheFileTailerV2();
    long startTime = System.currentTimeMillis();
    List<String> lines = tailer.tail(FILE_NAME);
    long endTime = System.currentTimeMillis();

    System.out.println("FILE TAIL ============== Took : "+ (endTime - startTime) + "ms");
    for(String line : lines){
      System.out.println(line);
    }

  }
}
