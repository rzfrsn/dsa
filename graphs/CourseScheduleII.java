class Solution {
    /**
     * Pattern : Graphs - DFS, Cycle Detection + Topological Sort (3-state marking)
     * Time : O(V + E) | Space : O(V + E)
     * 210. Course Schedule II
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(var prereq : prerequisites) {
            int a = prereq[0], b = prereq[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }

        int[] state = new int[numCourses];
        for(int course = 0; course < numCourses; course++) {
            if(hasCycle(course, graph, state, result)) return new int[0];
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> graph, int[] state, List<Integer> result) {
        if(state[course] == 1) return true;
        if(state[course] == 2) return false;

        state[course] = 1;

        for(var prereq : graph.getOrDefault(course, new ArrayList<>())) {
            if(hasCycle(prereq, graph, state, result)) return true;
        }

        state[course] = 2;
        result.add(course);
        return false;
    }
}
