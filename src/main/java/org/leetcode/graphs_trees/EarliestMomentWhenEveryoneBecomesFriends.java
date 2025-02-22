package org.leetcode.graphs_trees;

/*
There are n people in a social group labeled from 0 to n - 1.
 You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be
  friends at the time timestampi.

Friendship is symmetric. That means if a is friends with b, then b is friends with a.
Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person.
If there is no such earliest time, return -1.


==========================================

Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],
[20190312,1,2],[20190322,4,5]], n = 6
Output: 20190301
Explanation:
The first event occurs at timestamp = 20190101, and after 0 and 1 become friends, we have the following
friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104, and after 3 and 4 become friends, we have the following
friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107, and after 2 and 3 become friends, we have the following
friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211, and after 1 and 5 become friends, we have the following
friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224, and as 2 and 4 are already friends, nothing happens.
The sixth event occurs at timestamp = 20190301, and after 0 and 3 become friends, we all become friends.



================

Input: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
Output: 3
Explanation: At timestamp = 3, all the persons (i.e., 0, 1, 2, and 3) become friends.
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EarliestMomentWhenEveryoneBecomesFriends {

    public int earliestAcq(int[][] logs, int n) {
        /*
        create the vertex and rank arrays
         */
        int[] vertex = new int[n];
        int[] rank = new int[n];

        //initialise the vertex and rank arrays
        for (int i = 0; i < n; i++) {
            vertex[i] = i;
            rank[i] = 1;
        }

        AtomicInteger numberOfComponents = new AtomicInteger(n);
        /*
        traverse the logs matrix
        select one => run the unionByRank algorithm
            a simple modification is needed - when components are merged => update the above component Map
         */

        List<int[]> sortedLogs = new ArrayList<>();
        Collections.addAll(sortedLogs, logs);

        sortedLogs.sort(Comparator.comparingInt(o -> o[0]));

        for (int[] friendShipLog : sortedLogs) {
            int timeOfFriendship = friendShipLog[0];
            int friend1 = friendShipLog[1];
            int friend2 = friendShipLog[2];

            unionFindRank(friend1, friend2, vertex, rank, numberOfComponents);
            if (numberOfComponents.get() == 1) {
                return timeOfFriendship;
            }
        }

        return -1;
    }

    private void unionFindRank(int node1, int node2, int[] vertex,
                               int[] rank, AtomicInteger numberOfComponents) {
        int head1 = find(node1, vertex);
        int head2 = find(node2, vertex);

        if (head1 != head2) {
            int rank1 = rank[head1];
            int rank2 = rank[head2];

            numberOfComponents.decrementAndGet();
            if (rank1 > rank2) {
                vertex[head2] = head1;
            } else if (rank2 > rank1) {
                vertex[head1] = head2;
            } else {
                vertex[head2] = head1;
                rank[head1] += 1;
            }
        }
    }

    private int find(int node, int[] vertex) {
        int head = vertex[node];
        if (head == node) {
            return node;
        }

        return vertex[node] = find(head, vertex);
    }
}
