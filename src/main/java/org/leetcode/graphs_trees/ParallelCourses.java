package org.leetcode.graphs_trees;

/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations
where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and
course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

=========================================


Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.


========================================

Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they are prerequisites of each other.


================

Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
 */

import java.util.*;

public class ParallelCourses {

    private static class NodeData {

        private int inDegree;
        private Set<Integer> associatedNodes;


        public NodeData() {
            this.inDegree = 0;
            associatedNodes = new HashSet<>();
        }

        public void addNode(int node) {
            associatedNodes.add(node);
        }

        public void decrementInDegree() {
            this.inDegree -= 1;
        }

        public void incrementInDegree() {
            this.inDegree += 1;
        }

        public int getInDegree() {
            return inDegree;
        }

        public Set<Integer> getAssociatedNodes() {
            return associatedNodes;
        }

        @Override
        public String toString() {
            return "NodeData{" +
                    "inDegree=" + inDegree +
                    ", associatedNodes=" + associatedNodes +
                    '}';
        }
    }

    public int minimumSemesters(int n, int[][] relations) {

        Map<Integer, NodeData> graph = new HashMap<>();

        for (int[] condition : relations) {
            int firstNode = condition[0];
            int laterNode = condition[1];

            NodeData dataFirst = graph.computeIfAbsent(firstNode, nd -> new NodeData());

            if(!dataFirst.getAssociatedNodes().contains(laterNode)) {
                dataFirst.addNode(laterNode);
                NodeData dataLater = graph.computeIfAbsent(laterNode, bd -> new NodeData());
                dataLater.incrementInDegree();
            }
        }

        System.out.println(graph);

        Queue<int[]> queue = new LinkedList<>();
        int startSem = 1;
        int lastSem = startSem;
        for (int i = 1 ; i <= n; i++) {
            NodeData nodeData = graph.getOrDefault(i, new NodeData());
            if (nodeData.getInDegree() == 0) {
                queue.add(new int[]{i, startSem});
            }
        }

        List<Integer> sortOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] element = queue.poll();

            int semNo = element[1];
            if(lastSem < semNo){
                lastSem = semNo;
            }
            sortOrder.add(element[0]);

            NodeData elementData = graph.getOrDefault(element[0], new NodeData());
            for (Integer edges : elementData.getAssociatedNodes()) {
                NodeData nodeData = graph.getOrDefault(edges, new NodeData());

                if (nodeData.getInDegree() > 0) {
                    nodeData.decrementInDegree();
                    if (nodeData.getInDegree() == 0) {
                        queue.add(new int[]{ edges, ++semNo });
                    }
                }
            }
        }

        System.out.println(sortOrder);

        if(sortOrder.size() != n){
            return -1;
        }

        return lastSem;
    }
}
