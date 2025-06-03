import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Create an adjacency list where each edge has a direction flag
        List<List<int[]>> graph = new ArrayList<>();
        
        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph with direction flag
        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];
            graph.get(from).add(new int[]{to, 0}); // original direction
            graph.get(to).add(new int[]{from, 1}); // reverse direction
        }
        
        // Track visited nodes
        boolean[] visited = new boolean[n];
        
        // Start DFS from node 0
        return dfs(0, graph, visited);
    }
    
    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;
        
        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int direction = neighbor[1];
            
            if (!visited[nextNode]) {
                // If direction is 0, it's going away from 0 and needs to be reversed
                count += direction == 0 ? 1 : 0;
                count += dfs(nextNode, graph, visited);
            }
        }
        
        return count;
    }
}
