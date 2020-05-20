package org.fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public class StreamFileTailer implements FileTailer {

  public static final int TAIL_LIMIT = 10;

  @Override
  public List<String> tail(String filename) {
    List<String> tailData = new ArrayList<>();
    CircularFifoQueue<String> queue = new CircularFifoQueue(TAIL_LIMIT);

    try {
      File file = new File(filename);
      long fileLength = file.length();
      System.out.println("Filename : " + filename + " ; Length :" + fileLength);
      if (fileLength > 0) {
        InputStream inputStream = new FileInputStream(file);
        Reader reader = new InputStreamReader(inputStream);

        char ch;
        String s = "";
        int i;
        while ((i = reader.read()) != -1) {
          ch = (char) i;
          if (ch == '\n') {
            queue.add(s);
            //initialize s to empty string
            s = "";
          }
          else {
            s += ch + "";
          }
        }
      }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }

    if (!queue.isEmpty()) {
      Iterator<String> iterator = queue.iterator();
      while (iterator.hasNext()) {
        tailData.add(iterator.next());
      }
    }

    return tailData;
  }
}
