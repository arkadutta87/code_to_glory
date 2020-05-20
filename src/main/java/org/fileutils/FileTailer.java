package org.fileutils;

import java.util.List;

public interface FileTailer {

  List<String> tail(String filename) ;
}
