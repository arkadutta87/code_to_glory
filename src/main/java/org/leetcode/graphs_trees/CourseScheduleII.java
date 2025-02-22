package org.leetcode.graphs_trees;

/*
There are a total of "numCourses" courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where
 prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 If it is impossible to finish all courses, return an empty array.



 =========================================
 Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].


=========================================
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].


========================================

Input: numCourses = 1, prerequisites = []
Output: [0]
 */

import java.util.*;
import java.util.stream.IntStream;

public class CourseScheduleII {

    private static class NodeData {

        private Set<Integer> connectedNodes;
        private int inDegree;

        public NodeData() {
            this.connectedNodes = new HashSet<>();
            this.inDegree = 0;
        }

        public void addNodes(int node) {
            this.connectedNodes.add(node);
        }

        public void incrementInDegree() {
            this.inDegree += 1;
        }

        public void decrementInDegree() {
            this.inDegree -= 1;
        }

        public Set<Integer> getConnectedNodes() {
            return connectedNodes;
        }

        public int getInDegree() {
            return inDegree;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, NodeData> graph = new HashMap<>();

        ArrayList<Integer> orderedCourses = new ArrayList<>();
        for (int[] dependencies : prerequisites) {
            int later = dependencies[0];
            int first = dependencies[1];

            NodeData nodeDataFirst = graph.computeIfAbsent(first, k -> new NodeData());
            nodeDataFirst.addNodes(later);

            NodeData nodeDataLater = graph.computeIfAbsent(later, k -> new NodeData());
            nodeDataLater.incrementInDegree();
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Integer startNode : IntStream.range(0, numCourses).toArray()) {
            NodeData nodeData = graph.computeIfAbsent(startNode, k -> new NodeData());
            if(nodeData.getInDegree() == 0){
                queue.add(startNode);
            }
        }

        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            orderedCourses.add(element);

            NodeData elementNodeData = graph.getOrDefault(element, new NodeData());
            Set<Integer> connectedNodes = elementNodeData.getConnectedNodes();

            for (int connection : connectedNodes) {
                NodeData connectionData = graph.getOrDefault(connection, new NodeData());
                if (connectionData.getInDegree() > 0) {

                    connectionData.decrementInDegree();
                    if (connectionData.getInDegree() == 0) {
                        queue.add(connection);
                    }
                }
            }
        }

        if(orderedCourses.size() != numCourses){
            return new int[]{};
        }

        return orderedCourses.stream().mapToInt(Integer::intValue).toArray();
    }
}
