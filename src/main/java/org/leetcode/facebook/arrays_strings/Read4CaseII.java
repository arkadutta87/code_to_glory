package org.leetcode.facebook.arrays_strings;

public class Read4CaseII {

  char[] internalBuffer = new char[4];
  int internalIndex = -1;
  int lastRead = 0;

  /**
   * @param buf Destination buffer
   * @param n Number of characters to read
   * @return The number of actual characters read
   */
  private int read4(char[] buf) {
    return 0;
  }

  public int read(char[] buf, int n) {
    int index = -1;

    if (internalIndex >= 0 && internalIndex < lastRead) {
      for (; (internalIndex < (lastRead - 1)) && (index < (n - 1)); ) {
        buf[++index] = internalBuffer[++internalIndex];
      }

      if (internalIndex == (lastRead - 1)) {
        internalIndex = -1;
      }
    }

    while (index < (n - 1) && (lastRead = read4(internalBuffer)) == 4) {
      for (int i = 0; i < lastRead && (index < (n - 1)); i++) {
        buf[++index] = internalBuffer[i];
        //increase the internal count
        ++internalIndex;
      }

      if (internalIndex == (lastRead - 1)) {
        internalIndex = -1;
      }
    }

    for (int i = 0; i < lastRead && (index < (n - 1)); i++) {
      buf[++index] = internalBuffer[i];
      //increase the internal count
      ++internalIndex;
    }

    if (internalIndex == (lastRead - 1)) {
      internalIndex = -1;
    }

    return index + 1;
  }
}
