package org.concurrency_cookbook.fork_join.recipe2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentTask extends RecursiveTask<Integer> {

  private String[][] document;
  private int start, end;
  private String word;


  @Override
  protected Integer compute() {
    Integer result = null;

    if (end - start < 10) {
      result = processLines(document, start, end, word);
    }
    else {
      int mid = (start + end) / 2;
      DocumentTask task1 = new DocumentTask(document, start, mid, word);
      DocumentTask task2 = new DocumentTask(document, mid, end, word);
      invokeAll(task1, task2);

      try {
        groupResults(task1.get(), task2.get());
      }
      catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    return result;
  }

  private int groupResults(int number1, int number2) {
    return number1 + number2;
  }

  private Integer processLines(String[][] document, int start, int end, String word) {
    List<LineTask> tasks = new ArrayList<>();
    for (int i = start; i < end; i++) {
      LineTask task = new LineTask(document[i], 0, document[i].length, word);
      tasks.add(task);
    }

    invokeAll(tasks);

    int result = 0;
    for (int i = 0; i < tasks.size(); i++) {
      LineTask task = tasks.get(i);
      try {
        result = result + task.get();
      }
      catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    return result;
  }
}
