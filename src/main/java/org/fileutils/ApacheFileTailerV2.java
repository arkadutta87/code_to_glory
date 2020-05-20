package org.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class ApacheFileTailerV2 implements FileTailer {

  public static final int LAST_N_LINES = 10;

  @Override
  public List<String> tail(String filename) {
    File file = new File(filename);

    Stack<String> lines = new Stack<>();
    try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, StandardCharsets.UTF_8)) {

      String line = "";
      while ((line = reader.readLine()) != null && lines.size() < LAST_N_LINES) {
        lines.push(line);
      }

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    Iterator<String> iterator = lines.iterator();
    List<String> result = new ArrayList<>();

    while (iterator.hasNext()) {
      result.add(iterator.next());
    }

    return result;
  }
}
