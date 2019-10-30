package org.leetcode.facebook.tree_graphs;

import java.util.List;

public class Node {

  public int val;
  public List<Node> neighbors;

  public Node(){}

  public Node(int _val, List<Node> _neighbours){
    this.val = _val;
    this.neighbors = _neighbours;
  }


}
