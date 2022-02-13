package GraphAlgorithms.topologicalsort;

import LargestCycle_DiameterProblem.TestClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class CourseScheduleII {
    /*
    Link: https://leetcode.com/problems/course-schedule-ii/

    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
    If it is impossible to finish all courses, return an empty array.

    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
    So the correct course order is [0,1].

    Example 2:

    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take.
    To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3].
    Another correct ordering is [0,2,1,3].
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TreeMap<Integer, List<Integer>> adjList = new TreeMap<>();
        for (int a[] :
                prerequisites) {
            addEdge(adjList, a[0], a[1]);
        }
        int visited[] = new int[numCourses];
        LinkedList<Integer> ans = new LinkedList<>();
        for (int u = 0; u < numCourses; u++) {
            if (visited[u] == 0) //if u is not processed yet
                topSort(adjList, u, visited, ans);
        }
        int arr[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return cycleFound ? new int[0] : arr;
    }

    boolean cycleFound = false;

    // for visited[]: 0->not visited, 2->in process, 1->processed
    void topSort(TreeMap<Integer, List<Integer>> adjList, int u, int[] visited, LinkedList<Integer> ans) {
        if (cycleFound) {
            cycleFound = true;
            return;
        }
        visited[u] = 2; //u is under process
        if (adjList.get(u) != null) {
            for (Integer v : adjList.get(u)) {
                switch (visited[v]) {
                    case 0:
                        topSort(adjList, v, visited, ans);
                        break;
                    case 1:
                        continue;
                    case 2:
                        cycleFound = true;
                        return;
                }
            }
        }
        visited[u] = 1; //all neighbors of u are visited
        ans.add(u);
    }

    void addEdge(TreeMap<Integer, List<Integer>> adjList, int u, int v) {
        adjList.compute(u, (key, value) -> {
            if (value == null)
                return new ArrayList<>(List.of(v));
            value.add(v);
            return value;
        });
    }

    public static void main(String[] args) {

    }
}
