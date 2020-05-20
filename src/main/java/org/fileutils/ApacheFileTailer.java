package org.fileutils;

import org.apache.commons.io.input.Tailer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApacheFileTailer implements FileTailer {

  @Override
  public List<String> tail(String filename){
    File file = new File(filename);
    List<String> lines = new ArrayList<>();

    Tailer fileTailer = new Tailer(file, new ApacheFileTailerListener(lines));
    Thread thread = new Thread(fileTailer);
    thread.setDaemon(true); // optional
    thread.start();

    try {
      Thread.sleep(20000l);
    }catch (InterruptedException e){

    }finally {
      fileTailer.stop();
    }

    return lines;
  }
}
