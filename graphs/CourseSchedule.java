class Solution {
    /**
     * Pattern : Graphs - DFS, Cycle Detection in a Directed Graph (3-state marking)
     * Time : O(V + E) | Space : O(V + E)
     * 207. Course Schedule
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }

        int[] state = new int[numCourses];

        for(int course = 0; course < numCourses; course++) {
            if(hasCycle(course, graph, state)) return false;
        }

        return true;
    }

    /**
     *  {@code state} : a current state of the course
     * - 0 : course was not visited yet
     * - 1 : course is in exploration (memorized in the stack)
     * - 2 : course was fully explored
     */
    public boolean hasCycle(int course, Map<Integer, List<Integer>> graph, int[] state) {
        if(state[course] == 1) return true;
        if(state[course] == 2) return false;

        state[course] = 1;

        for(int prereq : graph.getOrDefault(course, new ArrayList<>())) {
            if(hasCycle(prereq, graph, state)) return true;
        }

        state[course] = 2;

        return false;
    }
}
