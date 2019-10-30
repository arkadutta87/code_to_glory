package org.leetcode.facebook.tree_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class CloneGraphV2 {

  public Node cloneGraph(Node node) {
    Map<Integer, Node> nodes = new HashMap<>();
    Map<Integer, Map<Integer, Boolean>> map = new TreeMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    Node head = null;

    while (!queue.isEmpty()) {
      Node pNode = queue.poll();
      List<Node> nbrs = pNode.neighbors;
      Node newP = null;

      if (nodes.get(pNode.val) != null) {
        newP = nodes.get(pNode.val);
      }
      else {
        newP = new Node(pNode.val, new ArrayList<Node>());
        if (nodes.size() == 0)
          head = newP;

        nodes.put(pNode.val, newP);
      }

      for (Node cNode : nbrs) {
        if (!map.containsKey(pNode.val) || !map.get(pNode.val).containsKey(cNode.val)) {
          Node newNode = null;
          if (!nodes.containsKey(cNode.val)) {
            List<Node> lst = new ArrayList<>();
            newNode = new Node(cNode.val, lst);
            nodes.put(cNode.val, newNode);
          }
          else {
            newNode = nodes.get(cNode.val);
          }

          if (map.containsKey(pNode.val)) {
            Map<Integer, Boolean> sub = map.get(pNode.val);
            if (!sub.containsKey(cNode.val)) {
              sub.put(cNode.val, true);
            }
          }
          else {
            Map<Integer, Boolean> sub = new TreeMap<>();
            sub.put(cNode.val, true);
            map.put(pNode.val, sub);
          }

          newP.neighbors.add(newNode);
          queue.add(cNode);
        }
      }
    }

    return head;
  }

}
