import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            completedCourses++;

            for (int nextCourse : graph.get(current)) {

                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completedCourses == numCourses;
    }

    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] prerequisites1 = {
                {1, 0}
        };

        int numCourses2 = 2;
        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        int numCourses3 = 4;
        int[][] prerequisites3 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        System.out.println(canFinish(numCourses1, prerequisites1)); // true
        System.out.println(canFinish(numCourses2, prerequisites2)); // false
        System.out.println(canFinish(numCourses3, prerequisites3)); // true
    }
}