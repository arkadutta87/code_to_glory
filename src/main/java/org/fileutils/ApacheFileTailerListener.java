package org.fileutils;

import java.util.List;

import org.apache.commons.io.input.TailerListenerAdapter;

public class ApacheFileTailerListener extends TailerListenerAdapter {

  private List<String> lines;

  public ApacheFileTailerListener(List<String> lines){
    this.lines = lines;
  }

  public void handle(String line) {
    lines.add(line);
  }
}
