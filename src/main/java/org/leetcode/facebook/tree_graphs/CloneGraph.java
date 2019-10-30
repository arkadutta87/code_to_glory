package org.leetcode.facebook.tree_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

  public Node cloneGraph(Node node) {

    if (node == null) {
      return node;
    }

    Node clonedStart = new Node();
    clonedStart.val = node.val;
    clonedStart.neighbors = new ArrayList<>();

    //create a queue
    Queue<Node> queue = new LinkedList<>();
    //create a map
    Map<Integer, Node> linkMap = new HashMap<>();
    //create a Set which contains all the traverse items
    Set<Node> alreadyTraversedItems = new HashSet<>();

    linkMap.put(node.val, clonedStart);
    for (Node aNeighbour : node.neighbors) {
      queue.add(aNeighbour);
    }
    alreadyTraversedItems.add(node);

    while (!queue.isEmpty()) {
      Node aNodeToBeCloned = queue.remove();

      if(alreadyTraversedItems.contains(aNodeToBeCloned)){
        continue;
      }

      Node duplicate = new Node();
      duplicate.val = aNodeToBeCloned.val;
      duplicate.neighbors = new ArrayList<>();

      for (Node aNode : aNodeToBeCloned.neighbors) {
        if (alreadyTraversedItems.contains(aNode)) {
          Node clonedAlready = linkMap.get(aNode.val);
          clonedAlready.neighbors.add(duplicate);
          duplicate.neighbors.add(clonedAlready);
        }
        else {
          queue.add(aNode);
        }
      }

      // add to the already traversed list
      alreadyTraversedItems.add(aNodeToBeCloned);
      //put a entry to the linkMap
      linkMap.put(aNodeToBeCloned.val, duplicate);

    }

    return clonedStart;
  }

}
