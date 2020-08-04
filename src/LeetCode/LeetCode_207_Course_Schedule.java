package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * ===========================================================================================
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * ===========================================================================================
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * ===========================================================================================
 */
public class LeetCode_207_Course_Schedule {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}


/**
 * 广度优先遍历
 */
class LeetCode_207_Course_Schedule_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}

class LeetCode_207_Course_Schedule_3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] arr : prerequisites) {
            graph[arr[1]].add(arr[0]);
        }
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfsVisit(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    boolean dfsVisit(int i, ArrayList[] graph, int[] visited) {
        visited[i] = 1;
        ArrayList<Integer> neighbours = graph[i];
        for (int j = 0; j < neighbours.size(); j++) {
            int neigh = neighbours.get(j);
            if (visited[neigh] == 1) {
                return false;
            }
            if (visited[neigh] == 0 && !dfsVisit(neigh, graph, visited)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
}